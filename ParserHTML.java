import java.io.File;
import org.apache.commons.io.*;
import java.io.IOException;
import org.apache.commons.lang3.*;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import model.*;
import util.*;

public class ParserHTML {
    private static HashMap<String, ArrayList<String>> sub = new HashMap<String, ArrayList<String>>();

    static {
        sub.put("pagina", new ArrayList<String>(Arrays.asList("?id?", "?nome?", "?nivel_de_acesso?", "?email?")));
        System.out.println("Hash map criado");
    }

    public static void main(final String args[]) {
        System.out.println(HTMLFactory(HomePageSelector.VIEW_GROUP_MEMBERS));
    }

    private static String HTMLFactory(String page) {
        File file = getFile(page);
        String pageHTMLNotFactored = getPageHTMLNotFactored(file);
        String factoredPageHTML = getFactoredPageHTML(pageHTMLNotFactored);
        return factoredPageHTML;
    }

    private static File getFile(String page) {
        String pageSRC = PageSRC.getPageSRCById(page);
        return new File(pageSRC);
    }

    private static String getPageHTMLNotFactored(File file) {
        try {
            return FileUtils.readFileToString(file, "utf-8");
        } catch (final IOException e) {
            System.out.println("Erro de IO " + e.getMessage());
            return null;
        }
    }

    private static String getFactoredPageHTML(String pageHTMLNotFactored) {
        String title = getTitle(pageHTMLNotFactored);
        String header = getHeader(pageHTMLNotFactored);
        String content = getContent(pageHTMLNotFactored);
        String factoredContent = getFactoredContent(content);
        return title + header + factoredContent;
    }

    private static String getTitle(String page) {
        return StringUtils.substringBetween(page, "<!-- title -->");
    }

    private static String getHeader(String page) {
        return StringUtils.substringBetween(page, "<!-- header -->");
    }

    private static String getContent(String page) {
        return StringUtils.substringBetween(page, "<!-- content -->");
    }

    private static String getFactoredContent(String content) {
        ArrayList<String> tags = sub.get("pagina");
        String factoredContent = replaceTagFromHTML(content, tags);
        return factoredContent;
    }

    private static String replaceTagFromHTML(String content, ArrayList<String> tags) {
        for (String tag : tags) {
            content = StringUtils.replace(content, tag, "caique");
        }
        return content;
    }
}