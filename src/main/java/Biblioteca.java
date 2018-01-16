import java.io.PrintStream;
import java.util.ArrayList;

public class Biblioteca {
    private PrintStream printStream;
    private ArrayList<Book> books;

    public Biblioteca(PrintStream printStream, ArrayList<Book> books) {
        this.printStream = printStream;
        this.books = books;
    }

    public void displayWelcomeMessage() {
        printStream.println("Welcome to Biblioteca");
    }

    public void listBooks() {
        for (Book book : books) {
            book.displayDetails(printStream);
        }
    }

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Harry Potter", "J.K. Rowling", "1995"));
        Biblioteca biblioteca = new Biblioteca(System.out,books);


        biblioteca.init();
        //biblioteca.selectOption(bibl);
    }

    public void init() {
        Menu menu = new Menu(printStream, new String[]{"List Books"});
        displayWelcomeMessage();
        menu.displayOptions();
        //menu.selectOption();
    }
}
