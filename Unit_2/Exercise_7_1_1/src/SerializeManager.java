import java.io.*;
import java.util.logging.Logger;

public class SerializeManager {

    private final File file;
    private final Logger log = Logger.getLogger(SerializeManager.class.getName());

    public SerializeManager(String fileName)
    {
        this.file = new File(fileName);
    }

    /*
    *  Serializa a ContactManager object.
    * */
    public void saveData(ContactManager myContacts)
    {
        try
        {
            if(!file.exists())
            {
                if(file.createNewFile())
                {
                    System.out.println("File created.");
                }
            }
            else
            {
                System.out.println("Saving file.");
            }

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
//            out.writeInt(1);
            out.writeObject(myContacts);
            System.out.println("File successfully loaded.");
            out.close();
        }
        catch (IOException e)
        {
            log.severe("Error saving file: " + e.getMessage());
        }
    }

    /*
    * retuns a ContactManger object.
    * */
    public ContactManager loadData()
    {
        ContactManager myContacts = null;
        try
        {
            if(!file.exists())
            {
                System.err.println("File does not exist.");
            }
            else
            {
                System.out.println("Loading file.");
                ObjectInputStream objectsFile = new ObjectInputStream(new FileInputStream(file));
//                int numObj = objectsFile.readInt();

//                if(numObj > 0)
//                {
                    myContacts = (ContactManager) objectsFile.readObject();
                    System.out.println("File successfully loaded.");
//                }
//                else
//                {
//                    System.out.println("There are no objects to read.");
//                }

                objectsFile.close();
            }
        }
        catch (IOException e)
        {
            log.severe("Error loading file: " + e.getMessage());
        }
        catch (ClassNotFoundException cnfe)
        {
            log.severe("Error during deserialization. : " + cnfe.getMessage());
        }

        return myContacts;
    }
}