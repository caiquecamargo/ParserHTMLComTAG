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

public class ParserHTML{
    private static HashMap<String, ArrayList<String>> sub = new HashMap<String, ArrayList<String>>();
	
	static {
	     sub.put(, new ArrayList<String>(Arrays.asList("?id?","?nome?","?src?","?tipo?")));
	     System.out.println("Hash map criado");
	}
    public static void main(String args[]){
        File file = new File("./teste.html");
        System.out.println(file.getPath());
        ArrayList<String> list = sub.get("pagina");
        String testHtml = null;
        try{
            testHtml = FileUtils.readFileToString(file, "utf-8");
        } catch(IOException e) {
            System.out.println("Erro de IO " + e.getMessage());
        }
        for(String x:list){
            testHtml = StringUtils.replace(testHtml, x, "caique");
            System.out.println(testHtml);
            System.out.println("-----------------------------------------");
        }
    }
}