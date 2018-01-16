import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MenuTests {

    private Menu menu;
    private PrintStream printStream = mock(PrintStream.class);
    private Biblioteca biblioteca = mock(Biblioteca.class);
    private final BufferedReader bufferedReader = mock(BufferedReader.class);


    @Before
    public void setUp(){

        String[] options = {"List Books"};

        menu = new Menu(printStream,options,bufferedReader, biblioteca);
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
        when(bufferedReader.readLine()).thenReturn("String").thenReturn("1");
        menu.getUserInput(bufferedReader);

        verify(printStream).println("Invalid Menu Option");
    }

    @Test
    public void getUserInputShouldReturnIntWhenGivenIntegerString() throws IOException {
        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("1");

        int result = menu.getUserInput(bufferedReader);

        assertEquals(1,result);
    }

    /*
    @Test
    public void shouldExitAppWhenUserSelectsOptionTwo(){
        menu.selectOption(biblioteca, 2);

        //verify(biblioteca).quit();
    }
    */
    @Test
    public void shouldDisplayWelcomeMessageWhenAppStarts(){
        String message = "Welcome to Biblioteca";
        menu.displayWelcomeMessage();

        verify(printStream).println("Welcome to Biblioteca");
    }

    @Test
    public void shouldDisplayGoodbyeWhenUserQuits(){
        menu.quit();
        verify(printStream).println("Goodbye!");
    }

}
