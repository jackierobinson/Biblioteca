import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class Menu {
    private final String[] options;
    private final PrintStream printStream;
    private final BufferedReader bufferedReader;
    private final Biblioteca biblioteca;



    public Menu(PrintStream printStream, String[] options, BufferedReader bufferedReader, Biblioteca biblioteca) {
        this.options = options;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.biblioteca = biblioteca;
    }
    
    public void displayOptions() {
        for (int i = 0; i < options.length; i++) {
            printStream.println(i+1 + ": " + options[i]);
        }
    }

    public boolean selectOption(int option) {


        if (optionsIsInvalid(option)){
            printStream.println("Invalid Menu Option");
            return true;
        }
        if(option == 2){
            return false;
        }
        else {
            biblioteca.listBooks();
            return true;
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

        Menu menu = new Menu(printStream, new String[]{"List Books", "Quit"}, bufferedReader, biblioteca);

        menu.run();
    }

    public void run(){
        displayWelcomeMessage();
        boolean shouldRun = true;

        while(shouldRun){
            displayOptions();
            int userInput = getUserInput(bufferedReader);
            shouldRun = selectOption(userInput);
        }

        printStream.println("Goodbye!");

    }

    public void displayWelcomeMessage() {
        printStream.println("Welcome to Biblioteca");
    }

}
