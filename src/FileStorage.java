import java.io.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class FileStorage {
    private static final String filename = "library.json";
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    public static Library readFromFile()
    {
        
        File file = new File(filename);
        if(!file.exists())
            return null;
        try(FileReader reader = new FileReader(file))
        {
            return gson.fromJson(reader, Library.class);
        }
        catch(IOException exception)
        {
            System.out.println("Exception " + exception);
            System.out.println("Cannot read from file " + filename);
            return null;
        }
    }
    public static void saveToFile(Library data)
    {
        try(FileWriter writer = new FileWriter(filename))
        {
            gson.toJson(data, writer);
            System.out.println("Your data is saved");
        }
        catch(IOException exception)
        {
            System.out.println("Exception " + exception);
            System.out.println("Cannot save your data");
        }
        catch(NullPointerException exception)
        {
            System.out.println("Exception " + exception);
            System.out.println("Cannot save your data");
        }
    }
}
