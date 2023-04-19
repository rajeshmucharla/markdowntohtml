package com.intuit.markdowntohtml.parser;

public class EmptyLineParser implements Parser {

    /**
     *
     * Parses Blank lines in the markdown
     * @param reader
     * @return parsed String
     */
    public String parse(StringParser reader) {
        reader.peekNextLine();
        if(reader.hasNext()) {
            StringBuilder emptyLines = new StringBuilder();
            while(reader.isEmptyLine()) {
                reader.readNextLine();
                emptyLines.append("\n");
                if (reader.hasNext()) {
                    reader.peekNextLine();
                } else {
                    break;
                }
            }
            return String.valueOf(emptyLines);
        }
        return "";
    }
}
