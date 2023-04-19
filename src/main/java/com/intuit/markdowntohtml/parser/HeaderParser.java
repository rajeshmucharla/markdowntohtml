package com.intuit.markdowntohtml.parser;

import j2html.tags.specialized.*;

import static j2html.TagCreator.*;

public class HeaderParser implements Parser{

    /**
     *
     * represents the heading size
     */
    private int size;

    /**
     *
     * Parses Headings from the markdown
     * @param reader
     * @return parsed String
     */
    @Override
    public String parse(StringParser reader) {
        reader.peekNextLine();
        if(reader.hasHeader()) {
            String line = reader.readNextLine();
            size = reader.matchMultiple(StringParser.HEADER_IDENTIFIER);
            switch (size) {
                case 0:
                    return null;
                case 1:
                    H1Tag h1Tag = h1(line.substring(1).trim());
                    return h1Tag.render();
                case 2:
                    H2Tag h2Tag = h2(line.substring(2).trim());
                    return h2Tag.render();
                case 3:
                    H3Tag h3Tag = h3(line.substring(3).trim());
                    return h3Tag.render();
                case 4:
                    H4Tag h4Tag = h4(line.substring(4).trim());
                    return h4Tag.render();
                case 5:
                    H5Tag h5Tag = h5(line.substring(5).trim());
                    return h5Tag.render();
                default:
                    H6Tag h6Tag = h6(line.substring(6).trim());
                    return h6Tag.render();
            }
        } else {
            return "";
        }
    }
}