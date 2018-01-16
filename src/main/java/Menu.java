import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Menu {
    private final String[] options;
    private final PrintStream printStream;


    public Menu(PrintStream printStream, String[] options) {
        this.options = options;
        this.printStream = printStream;

    }
    
    public void displayOptions() {
        for (int i = 0; i < options.length; i++) {
            printStream.println(i+1 + ": " + options[i]);
        }
    }

    public void selectOption(Biblioteca biblioteca, int option) {
        if (optionsIsInvalid(option)){
            printStream.println("Invalid Menu Option");
        }
        else {
            biblioteca.listBooks();
        }

    }

    private boolean optionsIsInvalid(int option) {
        return option<1 || option > options.length;
    }

    public void getUserInput(BufferedReader bufferedReader) {

        try {
            String userInput = bufferedReader.readLine();
            Integer.parseInt(userInput);

        } catch (IOException | NumberFormatException e) {
            printStream.println("Invalid Menu Option");
        }
    }
}
