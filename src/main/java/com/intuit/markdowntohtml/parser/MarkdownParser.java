package com.intuit.markdowntohtml.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class MarkdownParser {

    /**
     * List of Block level parser
     */
    List<Parser> blockParsers = new ArrayList<>();
    {
        blockParsers.add(new HeaderParser());
        blockParsers.add(new EmptyLineParser());
        blockParsers.add(new UnformattedTextParser());
    }

    /**
     * List of inline parsers like Link
     */
    List<InlineParser> inlineParsers = new ArrayList<>();
    {
        inlineParsers.add(new LinkParser());
    }

    /**
     * Parse through the input markdown string to return html string
     * @param input
     * @return
     */
    public String parseMarkdown(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        StringParser reader = new StringParser(input.lines().collect(Collectors.toList()));
        while(reader.hasNext()) {
            blockParsers.forEach((parser -> {
                String str = parser.parse(reader);
                if(!str.equals(""))
                    stringBuilder.append(str);
            }));
        }

        AtomicReference<String> output = new AtomicReference<>();
        output.set(stringBuilder.toString());
        inlineParsers.forEach((inlineParser -> {
            output.set(inlineParser.parse(output.get()));
        }));

        return output.get().trim();
    }
}
