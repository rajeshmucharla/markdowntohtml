package com.intuit.markdowntohtml.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringParserTest {

    private StringParser stringParserUnderTest;

    @BeforeEach
    void setUp() {
        stringParserUnderTest = new StringParser(List.of("line"));
        stringParserUnderTest.peekNextLine();
    }

    @Test
    void testHasNext() {
        // Setup
        // Run the test
        boolean result = stringParserUnderTest.hasNext();

        // Verify the results
        assertThat(result).isTrue();

        stringParserUnderTest.readNextLine();

        result = stringParserUnderTest.hasNext();
        // Verify the results
        assertThat(result).isFalse();

    }

    @Test
    void testReadNextLine() {
        // Setup
        // Run the test
        final String result = stringParserUnderTest.readNextLine();

        // Verify the results
        assertThat(result).isEqualTo("line");
    }

    @Test
    void testPeekNextLine() {
        // Setup
        // Run the test
        final String result = stringParserUnderTest.peekNextLine();

        // Verify the results
        assertThat(result).isEqualTo("line");
    }

    @Test
    void testReadNextChar() {
        // Setup
        // Run the test
        final char result = stringParserUnderTest.readNextChar();

        // Verify the results
        assertThat(result).isEqualTo('l');
    }

    @Test
    void testMatchMultiple() {
        // Setup
        // Run the test
        final int result = stringParserUnderTest.matchMultiple('#');

        // Verify the results
        assertThat(result).isEqualTo(0);
    }

    @Test
    void testStartsWith() {
        // Setup
        // Run the test
        final boolean result = stringParserUnderTest.startsWith('a');

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testIsParagraph() {
        // Setup
        // Run the test
        final boolean result = stringParserUnderTest.isParagraph();

        // Verify the results
        assertThat(result).isTrue();
    }

    @Test
    void testHasHeader() {
        // Setup
        // Run the test
        final boolean result = stringParserUnderTest.hasHeader();

        // Verify the results
        assertThat(result).isFalse();
    }
}
