package db;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by Lidia on 20.05.2020.
 */
public class ReadSQLFile {
    public static String getText(String fileName)throws IOException{
        ClassLoader classLoader = ReadSQLFile.class.getClassLoader();
        try {
            InputStream inputStream = classLoader.getResourceAsStream("sql/"+fileName+".sql");
            Scanner scanner = new Scanner(inputStream);
            String data = "";
            while (scanner.hasNextLine()){
                data += scanner.nextLine();
            }
            return data;
        }catch (Exception e){
            e.printStackTrace();
        }
        return fileName;
    }
}
