import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class BalabolkaCommon
{
    public static void main(String[] args) throws Exception
    {

        final String destinationPath = "D:/AAA/";
        final String sourcePath = "D:\\lockelt\\21 Of Power\\";
        final String sourceFolder = "61";

        StringBuilder sb = new StringBuilder();

        Balabolka1.scenarijus2(sb, sourceFolder, "Regina","Vladas", "Emma", "Brian");
        Balabolka1.scenarijus2(sb, sourceFolder+"_", "Aiste","Edvardas", "Salli", "Russel");


        BalabolkaEN.scenarijus2( destinationPath, sourcePath, sourceFolder,sourceFolder+"en", "Emma", "Brian" );
        BalabolkaEN.scenarijus2( destinationPath, sourcePath, sourceFolder, sourceFolder+"en_", "Salli", "Russel" );

        BalabolkaRU.scenarijus2( destinationPath, sourcePath, sourceFolder,sourceFolder+"ru", "Tatyana", "Maxim" );
        BalabolkaRU.scenarijus2( destinationPath, sourcePath, sourceFolder,sourceFolder+"ru_", "Katya", "Yuri" );

        System.out.println( sb );

        StringSelection stringSelection = new StringSelection(sb.toString());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
}
