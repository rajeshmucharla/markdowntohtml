package com.intuit.markdowntohtml.parser;

public class LinkParser implements InlineParser {

    /**
     * Parses string for any links and returs the string by replacing links with anchor tag (<a></a>)
     * @param line String
     * @return String
     */
    public String parse(String line) {
        String linkRegex = "\\[([^\\[\\]]+)\\]\\(([^\\(\\)]+)\\)";
        String htmlTemplate = "<a href=\"%s\">%s</a>";
        line = line.replaceAll(linkRegex, String.format(htmlTemplate, "$2", "$1"));
        return line;
    }
}
