package com.intuit.markdowntohtml.parser;

import static j2html.TagCreator.p;

public class UnformattedTextParser implements Parser{

    /**
     * parses Paragraph text in the markdown
     * @param reader
     * @return
     */
    @Override
    public String parse(StringParser reader) {
        reader.peekNextLine();
        if(reader.hasNext()) {
            StringBuilder paragraph = new StringBuilder();
            while(reader.isParagraph()) {
                String line = reader.readNextLine();
                if (paragraph.isEmpty()) {
                    paragraph.append(line);
                } else {
                    paragraph.append("\n" + line);
                }
                if (reader.hasNext()) {
                    reader.peekNextLine();
                } else {
                    break;
                }
            }
            return String.valueOf("\n" + p(String.valueOf(paragraph)));
        }
        return "";
    }

}
