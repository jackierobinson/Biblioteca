import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

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

    public int getUserInput(BufferedReader bufferedReader) {

        while(true) {
            try {
                String userInput = bufferedReader.readLine();
                return Integer.parseInt(userInput);

            } catch (IOException | NumberFormatException e) {
                printStream.println("Invalid Menu Option");
            }
        }
    }

    public static void main(String[] args) {

        PrintStream printStream = System.out;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Harry Potter", "J.K. Rowling", "1995"));
        Biblioteca biblioteca = new Biblioteca(System.out,books);

        Menu menu = new Menu(printStream, new String[]{"List Books"});

        menu.displayWelcomeMessage();

        menu.displayOptions();
        int userInput = menu.getUserInput(bufferedReader);
        menu.selectOption(biblioteca, userInput);
    }
    public void displayWelcomeMessage() {
        printStream.println("Welcome to Biblioteca");
    }

    public void quit() {
        printStream.println("Goodbye!");
    }
}
