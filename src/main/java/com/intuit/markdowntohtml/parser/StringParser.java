package com.intuit.markdowntohtml.parser;

import java.util.HashSet;
import java.util.List;

public class StringParser {

    /**
     * Identifier for headers
     */
    static char HEADER_IDENTIFIER = '#';

    HashSet<Character> blockIdentifiers = new HashSet<>();
    {
        blockIdentifiers.add(HEADER_IDENTIFIER);
    }

    /**
     * current line that is being parsed
     */
    private String line;

    /**
     * Input (list of lines) to be parsed.
     */
    private List<String> lines;

    /**
     * Current line index
     */
    private int lineIndex = 0;

    /**
     * Current character index in the current line
     */
    private int charIndex = 0;

    /**
     * Main reader to read the string
     * @param lines
     */
    public StringParser(List<String> lines) {
        this.lines = lines;
    }

    /**
     * Returns true if there is another line to parse
     * @return
     */
    public boolean hasNext() {
        if (lineIndex < lines.size()) {
            return true;
        } else {
            // No newline at end of last line
            return lineIndex < lines.size() - 1;
        }
    }

    /**
     * Reads the next line, and updates the current line index
     * @return
     */
    public String readNextLine() {
        if(hasNext()) {
            this.line = lines.get(lineIndex++);
            return this.line;
        }
        return null;
    }

    /**
     * Reads the next line to peek but the current line index does not change
     * @return
     */
    public String peekNextLine() {
        if(hasNext()) {
            this.line = lines.get(lineIndex);
            return this.line;
        }
        return null;
    }

    /**
     * Reads the next character and updates current character index for the current line
     * @return
     */
    public char readNextChar() {
        if (charIndex < this.line.length()) {
            for (int i = charIndex; i < line.length(); i++) {
                if (line.charAt(i) == '\t' || line.charAt(i) == ' ') {
                    continue;
                } else {
                    return line.charAt(charIndex++);
                }
            }
        }
        return '\0';
    }

    /**
     * returns how many times a character is repeated in the beginning of the current line
     * @param c
     * @return
     */
    public int matchMultiple(char c) {

        int count = 0;
        for(int i=0; i<line.length(); i++) {
            if(line.charAt(i) == c) {
                count +=1;
            } else {
                break;
            }
        }
        return count;
    }

    /**
     * Returns whether the current line starts with the given character
     * @param c
     * @return
     */
    public boolean startsWith(char c) {
        for(int i=0; i<line.length(); i++) {
            if(line.charAt(i) == '\t' || line.charAt(i) == ' ') {
                continue;
            } else if(line.charAt(i) == c) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * returns if the current line is unformatted/paragraph
     * @return
     */
    public boolean isParagraph() {
        return !isEmptyLine() && !blockIdentifiers.contains(readNextChar());
    }

    /**
     * returns if the current line is header
     * @return
     */
    public boolean hasHeader() {
        return startsWith(HEADER_IDENTIFIER);
    }

    /**
     * returns if the current line is blank line
     * @return
     */
    public boolean isEmptyLine() {
        return line.isBlank() || line.isEmpty();
    }
}