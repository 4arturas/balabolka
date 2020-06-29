import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.util.StringTokenizer;

public class BalabolkaLT
{
    static String txt = "";
    public static void main( String args[] )
    {

        StringBuilder sb = new StringBuilder();
        final String folder = "59";
        make( sb,"D:/AAA/"+folder+"lt/", "Regina", "Vladas" );
        make( sb,"D:/AAA/"+folder+"lt_/", "Aiste", "Edvardas" );

        StringSelection stringSelection = new StringSelection(sb.toString());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        System.out.println(sb);
    }

    static void make( StringBuilder sb, final String path, final String titleVoice, final String bodyVoice )
    {

        File f = new File(path);
        f.mkdir();

        StringTokenizer st = new StringTokenizer(txt, "\\.");
        int i = 1;
        while ( st.hasMoreTokens() )
        {
            String fileName = "" + i;
            if ( fileName.length() == 1 ) fileName = "0"+fileName;
            fileName = path + fileName + ".wav";

            if ( i == 1 )
            {
//                System.out.println( "sound_Init( "+titleVoice+" );");
                sb.append("sound_Init( "+titleVoice+" );");
            }
            else if ( i == 2 )
            {
//                System.out.println("sound_Destroy();"); // Regina sunaikiname
                sb.append("sound_Destroy();");
//                System.out.println( "sound_Init( "+bodyVoice+" );");
                sb.append("sound_Init( "+bodyVoice+" );");
            }
            i++;
            String str = st.nextToken();
            str = str.replaceAll("\n", " ");
            str = str.replaceAll("\"", "'");
            str = str.replaceAll("-", "");
            str += ",";
//            System.out.println("sound_Save( \""+fileName+"\", \""+str+"\" );");
            sb.append("sound_Save( \""+fileName+"\", \""+str+"\" );");
        } // end while
//        System.out.println("sound_Destroy();");
        sb.append("sound_Destroy();");
    }
}
