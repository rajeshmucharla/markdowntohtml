package com.intuit.markdowntohtml.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinkParserTest {

    private LinkParser linkParserUnderTest;

    @BeforeEach
    void setUp() {
        linkParserUnderTest = new LinkParser();
    }

    @Test
    void testParse() {
        assertThat(linkParserUnderTest.parse("[click](https://google.com)")).isEqualTo("<a href=\"https://google.com\">click</a>");
    }
}
