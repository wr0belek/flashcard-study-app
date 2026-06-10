import java.io.*;

public class FileStorage {
    private static final String filename = "library.ser";
    public static Library readFromFile()
    {
        File file = new File(filename);
        if(!file.exists())
            return null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename)))
        {
            return (Library) ois.readObject();
        }
        catch(IOException exception)
        {
            System.out.println("Exception " + exception);
            System.out.println("Cannot read from file " + filename);
            return null;
        }
        catch(ClassNotFoundException exception)
        {
            System.out.println("Exception " + exception);
            System.out.println("Class not found");
            return null;
        }
    }
    public static void saveToFile(Library library)
    {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename)))
        {
            oos.writeObject(library);
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
