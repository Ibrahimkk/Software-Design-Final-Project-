package sdfinal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class SpellCheckerTest {
    SpellChecker spellChecker;

    @BeforeEach
    void setup() {spellChecker = new SpellChecker();}


    @Test
    void SpellCheckerThrowsNetworkError() throws IOException {
        SpellChecker spySpellChecker = spy(SpellChecker.class);
        when(spySpellChecker.createURL("****")).thenThrow(new IOException());

        Throwable exception = assertThrows(RuntimeException.class, () -> spySpellChecker.fetchIfCorrect("****"));
        assertEquals("Network Error", exception.getMessage());
    }

    @Test
    void getIfCorrectTest() throws IOException {
        assertTrue(spellChecker.getIfCorrect("monkey"));
    }

    @Test
    void getIfNotCorrectTest() throws IOException {
        assertFalse(spellChecker.getIfCorrect("monke"));
    }
}
