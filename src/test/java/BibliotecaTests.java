import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
public class BibliotecaTests {
    private PrintStream printstream;
    private Biblioteca biblioteca;

    @Before
    public void setUp()throws Exception{
        printstream = mock(PrintStream.class);
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Harry Potter", "J.K. Rowling", "1995"));
        books.add(new Book("Lord of the Rings", "Tolkien", "1970"));
        biblioteca = new Biblioteca(printstream, books);
    }



    @Test
    public void shouldDisplayBooksAfterWelcomeMessage() {
        biblioteca.listBooks();

        verify(printstream).println("Harry Potter | J.K. Rowling | 1995");
        verify(printstream).println("Lord of the Rings | Tolkien | 1970");


    }

    @Test
    public void shouldCallSelectOptionAfterUserInput(){
        Menu menu = mock(Menu.class);

    }


}
