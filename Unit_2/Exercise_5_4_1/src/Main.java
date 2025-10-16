import java.io.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        String answerUser="", fileName ="";
        boolean createFile, canOverride;

        try
        {
            while(!answerUser.equalsIgnoreCase("Exit program"))
            {
                Scanner myScanner = new Scanner(System.in);
                System.out.println("If you want to exit, just write: Exit program");
                System.out.println("Hi, please enter the file name: ");
                answerUser = myScanner.nextLine();

                if(!answerUser.equalsIgnoreCase("Exit program"))
                {
                    fileName = answerUser;

                    System.out.println("Is the file exists on your path? (Y/N)?");
                    answerUser = myScanner.nextLine();

                    if(!answerUser.equalsIgnoreCase("Exit program"))
                    {
                        createFile = answerUser.equalsIgnoreCase("N");

                        System.out.println("Do you want to override information? (Y/N)?");
                        answerUser = myScanner.nextLine();

                        if(!answerUser.equalsIgnoreCase("Exit program"))
                        {
                            canOverride = !answerUser.equalsIgnoreCase("Y");

                            writeUserNotes(fileName, createFile, canOverride);
                        }
                    }
                }
            }
        }
        catch(Exception e)
        {
            System.err.println("Error: " + e.getMessage());
        }

    }

    public static String askUserOptions(String message)
    {
        boolean correctAnswer = false;
        String userOption = "";

        while(!correctAnswer)
        {
            Scanner input = new Scanner(System.in);
            System.out.println("If you want to exit, just write: Exit program");
            System.out.println(message);
            userOption = input.nextLine();

            correctAnswer = userOption.equalsIgnoreCase("Y") || userOption.equalsIgnoreCase("N") || userOption.equalsIgnoreCase("Exit program");
        }

        return userOption;
    }

    public static void writeUserNotes(String fileName, boolean createFile, boolean canOverride)
    {
        String text = "";
        File myFile = new File(fileName);
        if(!myFile.exists() && !createFile)
        {
            System.err.println("File does not exist");
            return;
        }

        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(myFile, canOverride))))
        {
            if(createFile &&  myFile.createNewFile())
            {
                System.out.println("File created");
            }

            while(!text.equalsIgnoreCase("Exit program"))
            {
                Scanner input = new Scanner(System.in);
                System.out.println("If you want to exit, just write: Exit program");
                System.out.println("Enter the text you want to add: ");
                text = input.nextLine();

                if(!text.equalsIgnoreCase("Exit program"))
                {
                    pw.println(text);
                }
            }
        }
        catch (IOException e)
        {
            System.err.println("Error: " + e.getMessage());
        }

    }
}