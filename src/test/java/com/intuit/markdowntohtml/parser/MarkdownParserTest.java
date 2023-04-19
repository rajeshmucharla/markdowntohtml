package com.intuit.markdowntohtml.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MarkdownParserTest {

    private MarkdownParser markdownParserUnderTest;

    @BeforeEach
    void setUp() {
        markdownParserUnderTest = new MarkdownParser();
    }

    @Test
    void testParseMarkdown() {
        // Setup
        // Run the test
        final String result = markdownParserUnderTest.parseMarkdown("# Sample Document\n" +
                "\n" +
                "Hello!\n" +
                "\n" +
                "This is sample markdown for the [Mailchimp](https://www.mailchimp.com) homework assignment.");

        // Verify the results
        assertThat(result).isEqualTo("<h1>Sample Document</h1>\n" +
                "\n" +
                "<p>Hello!</p>\n" +
                "\n" +
                "<p>This is sample markdown for the <a href=\"https://www.mailchimp.com\">Mailchimp</a> homework assignment.</p>");
    }
}
