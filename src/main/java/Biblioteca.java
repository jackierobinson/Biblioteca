import java.io.PrintStream;
import java.util.ArrayList;

public class Biblioteca {
    private PrintStream printStream;
    private ArrayList<Book> books;

    public Biblioteca(PrintStream printStream, ArrayList<Book> books) {
        this.printStream = printStream;
        this.books = books;
    }


    public void listBooks() {
        for (Book book : books) {
            book.displayDetails(printStream);
        }
    }
}
