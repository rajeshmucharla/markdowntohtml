package com.intuit.markdowntohtml.controller;

import com.intuit.markdowntohtml.model.ConverterRequest;
import com.intuit.markdowntohtml.parser.MarkdownParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
@RestController
public class MainController {

    /**
     *
     * http post request to convert markdown string to html string
     * @param request
     * @return String
     */
    @PostMapping("/convert")
    @ResponseBody
    public String getHtmlFromMarkup(@RequestBody ConverterRequest request) {
        Logger logger = LoggerFactory.getLogger("MarkupToHtmlConverter");
        logger.info("Received the request", request.toString());

        try {
            MarkdownParser parser = new MarkdownParser();
            return parser.parseMarkdown(request.getMarkdown());
        } catch (Exception ex) {
            logger.error(ex.getMessage() + "/n" + ex.getStackTrace());
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Oops.. something went wrong, we will be right back.");
        }
    }
}
