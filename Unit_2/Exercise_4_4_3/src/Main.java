import java.io.FileInputStream;
import java.io.InputStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static final String FILE_NAME = "GoodSync.bmp";

    public static void main(String[] args)
    {
        byte[] myDecriptor = new byte[54];
        int bytesRead;

        try(InputStream myStream = new FileInputStream(FILE_NAME))
        {
            bytesRead = myStream.read(myDecriptor);

            if(bytesRead != 54)
            {
                System.out.println("Error: " + bytesRead + " bytes read.");
                return;
            }

            System.out.println(FILE_NAME + " Information: ");
            System.out.println("Size: " + decryptFourBytes((byte)myDecriptor[2],(byte)myDecriptor[3],(byte)myDecriptor[4],(byte)myDecriptor[5]));
            System.out.println("Width: " + decryptFourBytes((byte)myDecriptor[18],(byte)myDecriptor[19],(byte)myDecriptor[20],(byte)myDecriptor[21]));
            System.out.println("Height: " + decryptFourBytes((byte)myDecriptor[22],(byte)myDecriptor[23],(byte)myDecriptor[24],(byte)myDecriptor[25]));
            System.out.println("Compression: " + getCompression(decryptFourBytes((byte)myDecriptor[30],(byte)myDecriptor[31],(byte)myDecriptor[32],(byte)myDecriptor[33])));
        }
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }

    /*
    * Convert 4 bytes read to an integer value.
    * Use of the formula learned in class.
    * @return an integer in little-endian format.
    */
    private static int decryptFourBytes(byte firstByte, byte secondByte, byte thirdByte, byte fourthByte)
    {
        int firstInt = Byte.toUnsignedInt(firstByte);
        int secondInt = Byte.toUnsignedInt(secondByte);
        int thirdInt = Byte.toUnsignedInt(thirdByte);
        int fourthInt = Byte.toUnsignedInt(fourthByte);

        return firstInt + (secondInt * (int)Math.pow(256, 1)) + (thirdInt * (int)Math.pow(256, 2)) + (fourthInt * (int)Math.pow(256, 3));
    }

    /*
     * Returns a string showing the compression type.
     */
    private static String getCompression(int compression)
    {
        String value;
        switch (compression)
        {
            case 0:
                value = "uncompressed";
                break;
            case 1:
                value = "compressed RLE-8";
                break;
            case 2:
                value = "compressed RLE-4";
                break;
            default:
                value = "unknown";
                break;
        }
        return value;
    }

}