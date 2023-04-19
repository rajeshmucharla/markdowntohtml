package com.intuit.markdowntohtml.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HeaderParserTest {

    private HeaderParser headerParserUnderTest;

    @BeforeEach
    void setUp() {
        headerParserUnderTest = new HeaderParser();
    }

    @Test
    void testParse() {
        // Setup
        final StringParser reader = new StringParser(List.of("#####5"));

        // Run the test
        final String result = headerParserUnderTest.parse(reader);

        // Verify the results
        assertThat(result).isEqualTo("<h5>5</h5>");
    }
}
