package com.intuit.markdowntohtml.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UnformattedTextParserTest {

    private UnformattedTextParser unformattedTextParserUnderTest;

    @BeforeEach
    void setUp() {
        unformattedTextParserUnderTest = new UnformattedTextParser();
    }

    @Test
    void testParse() {
        // Setup
        final StringParser reader = new StringParser(List.of("a\nb\nc"));

        // Run the test
        final String result = unformattedTextParserUnderTest.parse(reader);

        // Verify the results
        assertThat(result).isEqualTo("<p>a\nb\nc</p>");
    }
}
