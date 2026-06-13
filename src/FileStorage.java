import java.io.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class FileStorage {
    private static final String filename = "library.json";
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    public static Library readFromFile()
    {
        
        File file = new File(filename);
        if(!file.exists()){
            System.out.println("No saved data found. Creating an empty library.");
            return new Library();
        }
        try(FileReader reader = new FileReader(file))
        {
            System.out.println("Importing data...");
            Library library = gson.fromJson(reader, Library.class);
            if(library == null)
                return new Library();
            else 
                return library;
        }
        catch(IOException exception)
        {
            System.out.println("No saved data found. Creating an empty library.");
            return new Library();
        }
        catch(NullPointerException exception)
        {
            System.out.println("No saved data found. Creating an empty library.");
            return new Library();
        }
    }
    public static void saveToFile(Library data)
    {
        System.out.println("Saving data...");
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
