import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        checkFileExtension(getFileName());
    }

    private static String getFileName()
    {
        String fileName = "";
        try(Scanner myScanner = new Scanner(System.in))
        {
            System.out.print("Enter the file name: ");
            fileName = myScanner.nextLine();
        }
        catch (Exception e)
        {
            System.err.println("Error: " + e.getMessage());
        }

        return fileName;
    }

    private static void checkFileExtension(String fileName)
    {
        int bytesRead;
        byte[] myDecriptor = new byte[6];
        String mensaje = "File format not found.";

        try(InputStream myStream = new FileInputStream(fileName))
        {
            bytesRead = myStream.read(myDecriptor);

            if(bytesRead != 6)
            {
                System.out.println("Error: " + bytesRead + " bytes read.");
                return;
            }

            if(myDecriptor[0] == (byte)0x42)
            {
                // First: check if the file is a BMP.
                if(myDecriptor[1] == (byte)0x4D)
                {
                    mensaje = "BMP file format detected.";
                }
            }

            // GIF
            if(myDecriptor[0] == (byte)0x47)
            {
                if(myDecriptor[1] == (byte)0x49 && myDecriptor[2] == (byte)0x46 && myDecriptor[3] == (byte)0x38 &&
                        (myDecriptor[4] == (byte)0x37 || myDecriptor[4] == (byte)0x39) && myDecriptor[5] == (byte)0x61)
                {
                    mensaje = "GIF file format detected.";
                }
            }

            // ICO
            if(myDecriptor[0] == (byte)0x00)
            {
                if(myDecriptor[1] == (byte)0x00 && myDecriptor[2] == (byte)0x01 && myDecriptor[3] == (byte)0x00)
                {
                    mensaje = "ICO file format detected.";
                }
            }

            // JPEG
            if(myDecriptor[0] == (byte)0xFF)
            {
                if(myDecriptor[1] == (byte)0xD8 && myDecriptor[2] == (byte)0xFF)
                {
                    mensaje = "JPEG file format detected.";
                }
            }

            // PNG
            if(myDecriptor[0] == (byte)0x89)
            {
                if(myDecriptor[1] == (byte)0x50 && myDecriptor[2] == (byte)0x4E && myDecriptor[3] == (byte)0x47)
                {
                    mensaje = "PNG file format detected.";
                }
            }

            System.out.println(mensaje);
        }
        catch (Exception e)
        {
            System.err.println("Error: " + e.getMessage());
        }
    }
}