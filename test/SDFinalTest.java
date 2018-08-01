package sdfinal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class SDFinalTest {
    SDFinal sdFinal;
    List<String> names;

    @BeforeEach
    void setup() {
        sdFinal = new SDFinal();
        names = new ArrayList<>();
        names.add("monkey");
        names.add("banana");
        names.add("cosmopolitan");
    }

    @Test
    void canaryTest() {
        assertTrue(true);
    }

    @Test
    void shuffleWordTest() {
        assertNotEquals(sdFinal.shuffleWord("monkey"), "monkey");
    }

    @Test
    void shuffleNameTest() {
        SDFinal spySDFinal = spy(SDFinal.class);
        when(spySDFinal.shuffleList(names)).thenReturn("monkey");

        assertEquals(spySDFinal.shuffleList(names), "monkey");
    }

    @Test
    void numberOfVowelsAndConsTest() {
        assertEquals(sdFinal.numberOfVowelsAndConsonants("monk", "monkey"), 7);
    }

    @Test
    void numberOfConsTest() {
        assertEquals(sdFinal.numberOfVowelsAndConsonants("m", "monkey"), 2);
    }

    @Test
    void numberOfConsAndVowelsWhenNotMatchingTest() {
        assertEquals(0, sdFinal.numberOfVowelsAndConsonants("kom", "monkey"));
    }
}
