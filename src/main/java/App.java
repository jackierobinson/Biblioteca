import java.io.PrintStream;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        PrintStream printStream = System.out;
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Harry Potter", "J.K. Rowling", "1995"));
        Biblioteca biblioteca = new Biblioteca(System.out,books);

        Menu menu = new Menu(printStream, new String[]{"List Books"});

        displayWelcomeMessage(printStream);

        menu.displayOptions();
    }
    public static void displayWelcomeMessage(PrintStream printStream) {
        printStream.println("Welcome to Biblioteca");
    }

}
