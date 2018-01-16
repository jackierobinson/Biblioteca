import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AppTest {
    @Test
    public void shouldDisplayWelcomeMessageWhenAppStarts(){
        String message = "Welcome to Biblioteca";
        PrintStream printStream = mock(PrintStream.class);
        App.displayWelcomeMessage(printStream);

        verify(printStream).println("Welcome to Biblioteca");
    }

}