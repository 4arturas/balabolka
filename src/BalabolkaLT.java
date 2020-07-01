import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.*;
import java.nio.charset.Charset;
import java.util.StringTokenizer;

public class BalabolkaLT
{
    static String txt = "";
    public static void main( String args[] )
    {
/*
        StringBuilder sb = new StringBuilder();
        final String folder = "60";
        make( sb,"D:/AAA/"+folder+"lt/", "Regina", "Vladas" );
        make( sb,"D:/AAA/"+folder+"lt_/", "Aiste", "Edvardas" );

        StringSelection stringSelection = new StringSelection(sb.toString());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        System.out.println(sb);
        */
    }

    public static void make( StringBuilder sb, final String sourcePath, final String sourceFolder, final String path,
                             final String titleVoice,
                             final String bodyVoice ) throws Exception {

        File f = new File(path);
        f.mkdir();

        final String inFile = sourcePath + sourceFolder + "\\"+sourceFolder+"_lt.txt";

        InputStream inputStream = new FileInputStream(inFile);
        Reader reader = new InputStreamReader(inputStream, Charset.forName("utf-8"));
        BufferedReader br = new BufferedReader( reader );
        StringBuffer sbInner = new StringBuffer();
        String s;
        while ( (s = br.readLine() ) != null)
        {
            sbInner.append( s );
            sbInner.append( "\n" );

        }
        br.close();
        reader.close();

        StringTokenizer st = new StringTokenizer(sbInner.toString(), "\\.");
        int i = 1;
        while ( st.hasMoreTokens() )
        {
            String fileName = "" + i;
            if ( fileName.length() == 1 ) fileName = "0"+fileName;
            fileName = path + fileName + ".wav";

            if ( i == 1 || i == 2 )
            {
//                System.out.println( "sound_Init( "+titleVoice+" );");
                sb.append("sound_Init( "+titleVoice+" );");
            }
            else if ( i == 3 )
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
