package commons;

import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Ido on 11-May-16.
 */
public class Utils {

    public static void Write(File file, List<JSONObject> jsonsList)
    {
        int fileIndex=1;
        for(JSONObject jsonObject : jsonsList)
        {
            File dir = new File(file+File.separator+"Extracted Jsons");
            if(!dir.exists())
            {
                dir.mkdir();
            }
            File modifiedFile = new File(dir, String.valueOf(fileIndex));
            writeToFiles(jsonObject.toString(), modifiedFile);
            fileIndex++;
        }
    }


    private static void writeToFiles(String str, File file)  {
        try {

            PrintWriter writer = new PrintWriter(file, "UTF-8");
            writer.println(str);
            writer.close();
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
