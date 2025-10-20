import java.io.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    
    public static void main(String[] args)
    {
        String word1, word2, fileName1, fileName2;

        fileName1 = getFileNameToRead("first");
        fileName2 = getFileNameToRead("second");

        final File myFile1 = new File(fileName1);    //new File("textList1.txt");
        final File myFile2 = new File(fileName2);   //new File("textList2.txt");
        final File sortedFile = new File("sortedFile.txt");

        try(BufferedReader br1 = new BufferedReader(new FileReader(myFile1));
            BufferedReader br2 = new BufferedReader(new FileReader(myFile2)))
        {
            if(!sortedFile.exists())
            {
                if(sortedFile.createNewFile())
                {
                    System.out.println("File created");
                }
                else
                {
                    System.err.println("An error occurred creating the file.");
                }
            }

            try(PrintWriter myWriter = new PrintWriter(new BufferedWriter(new FileWriter(sortedFile, false))))
            {
                word1 = br1.readLine();
                word2 = br2.readLine();

                while(word1 != null || word2 != null)
                {
                    if(word1 == null)
                    {
                        //System.out.println(word2);
                        myWriter.println(word2);
                        word2 = br2.readLine();
                    }
                    else if(word2 == null)
                    {
                        //System.out.println(word1);
                        myWriter.println(word1);
                        word1 = br1.readLine();
                    }
                    else if(word1.compareTo(word2) <= 0)
                    {
                        //System.out.println(word1);
                        myWriter.println(word1);
                        word1 = br1.readLine();
                    }
                    else
                    {
                        //System.out.println(word2);
                        myWriter.println(word2);
                        word2 = br2.readLine();
                    }
                }
            }
        }
        catch(IOException io)
        {
            System.err.println("Error: " + io.getMessage());
        }

        printSortedFile(sortedFile);
    }

    private static void printSortedFile(File sortedFile)
    {
        try(BufferedReader br = new BufferedReader(new FileReader(sortedFile)))
        {
            String myLine;
            while((myLine = br.readLine()) != null)
            {
                System.out.println(myLine);
            }
        }
        catch(IOException ioe)
        {
            System.err.println("Error: " + ioe.getMessage());
        }
    }

    private static String getFileNameToRead(String firstOrSecond)
    {
        String fileName = "";
        boolean exit = false;

        while(!exit)
        {
            try
            {
                Scanner scan = new Scanner(System.in);
                System.out.println("Default files names are: textList1.txt or textList2.txt ");
                System.out.printf("Please enter the sorted file name to read (%s file): ", firstOrSecond);
                fileName = scan.nextLine();

                // check file's name exists.
                File myFile = new File(fileName);
                if(myFile.exists())
                {
                    exit = true;
                }
                else
                {
                    System.err.println("File does not exist.");
                }
            }
            catch(Exception e)
            {
                System.err.println("Error: " + e.getMessage());
            }
        }

        return fileName;
    }

}