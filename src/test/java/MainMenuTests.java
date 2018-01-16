import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainMenuTests {

    private Menu menu;
    private PrintStream printStream = mock(PrintStream.class);
    private Biblioteca biblioteca = mock(Biblioteca.class);


    @Before
    public void setUp(){

        String[] options = {"List Books"};
        menu = new Menu(printStream,options);
    }

    @Test
    public void menuShouldDisplay(){


        menu.displayOptions();

        verify(printStream).println("1: List Books");

    }

    @Test
    public void listBooksShouldBeCalledWhenOptionsOneIsSelected(){
        Biblioteca biblioteca = mock(Biblioteca.class);

        menu.selectOption(biblioteca,1);

        verify(biblioteca).listBooks();

    }

    @Test
    public void shouldGiveInvalidOptionErrorIfOutofRange(){

        menu.selectOption(biblioteca, 3);

        verify(printStream).println("Invalid Menu Option");
    }

    @Test
    public void shouldGiveInvalidOptionErrorIfNegative(){

        menu.selectOption(biblioteca, -3);

        verify(printStream).println("Invalid Menu Option");
    }

    @Test
    public void  shouldGiveInvalidOptionErrorIfNotANumber() throws IOException {

        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("String");
        menu.getUserInput(bufferedReader);

        verify(printStream).println("Invalid Menu Option");
    }


}
