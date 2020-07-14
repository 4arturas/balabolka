
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.*;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Balabolka1
{
    static final String end1 = "_1.wav";
    static final String end2 = "_2.wav";

    static String txt = "";

    public static void main( String args[] ) throws Exception
    {
        StringBuilder sb = new StringBuilder();
//        scenarijus1();
        String folder = "61";
        scenarijus2(sb, folder, "Regina","Vladas", "Emma", "Brian");
        scenarijus2(sb, folder+"_", "Aiste","Edvardas", "Salli", "Russel");

        System.out.println( sb );

        StringSelection stringSelection = new StringSelection(sb.toString());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    public static void scenarijus2( StringBuilder sb, final String folder, final String titleVoiceLithuania,
                             final String bodyVoiceLithuatia, final String titleVoiceEnglish,
                             final String bodyVoiceEnglish ) throws Exception
    {

        final String inFile = "D:\\lockelt\\21 Of Power\\"+folder.replaceAll("_", "")+"\\"+folder.replaceAll("_", "")+
                ".txt";

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

        List<String> en = new LinkedList<String>();
        List<String> lt = new LinkedList<String>();
        split_Text( sbInner.toString(), en, lt );



        final String usbPath = "D:/AAA/"+folder+"/";
//        final String usbPath = "G:/John Locke/en-lt21 Of Power/"+fileNumber+"/";

        java.io.File f;
        f = new File(usbPath);
        f.mkdir();

        lithuanian( sb, lt ,usbPath, folder, end1, titleVoiceLithuania, bodyVoiceLithuatia );
//        lithuanian( lt ,usbPath, fileNumber, end1, "Aiste", "Edvardas" );
        english( en, usbPath, folder, end2, titleVoiceEnglish, bodyVoiceEnglish );
    }

    static void lithuanian( StringBuilder sb, List<String> l, final String path, final String folder, final String end,
                            final String titleVoice, final String bodyVoice )
    {
        int i = 1;

        for ( String s : l )
        {
            String fileName = "" + i;
            if ( fileName.length() == 1 ) fileName = "0"+fileName;
            fileName = path + folder + "_" + fileName + end;

            if ( i == 1 )
            {
                sb.append( "sound_Init( "+titleVoice+" );");
            }
            else if ( i == 2 )
            {
                sb.append( "sound_Init( "+bodyVoice+" );");
            }

            sb.append("sound_Save( \""+fileName+"\", \""+s+"\" );");

            if ( i == 1 )
            {
                sb.append("sound_Destroy();");
            }

            i++;
        } // end for s
        sb.append("sound_Destroy();");

    }
    static void english( List<String> l, final String path, final String folder, final String end,
                         final String titleVoice, final String bobyVoice )
    {
        int i = 1;
        String b = "D:\\Balabolka\\balcon.exe -w %s -n \"%s\" -s -4 -v 100 --silence-begin 1000 --silence-end 500 -t \"%s\"";
        for ( String s : l )
        {
            String voice = (i==1)?titleVoice:bobyVoice;

            String fileName = "" + (i++);
            if ( fileName.length() == 1 ) fileName = "0" + fileName;
            fileName = fileName + end;
            fileName = path + folder + "_" + fileName;


            s = String.format( b, fileName, voice, s);
//            System.out.println( s );
            try {
                Runtime.getRuntime().exec(s);
            }
            catch (IOException e) {
                e.printStackTrace();
            };
        }
        System.out.println();
    }
    static void split_Text(String txt, List<String> en, List<String> lt )
    {
        StringTokenizer st = new StringTokenizer(txt, "\n");
        int i = 0;
        while ( st.hasMoreTokens() )
        {
            String s = st.nextToken();
            s = s.trim();
            if ( i++ % 2 == 0 )
                en.add( s );
            else
                lt.add( s );
        } // end while
        if ( en.size() != lt.size() )
        {
            for ( i = 0; i < en.size(); i++ )
            {
                System.out.println("*"+en.get(i) + "*");
                System.out.println("*"+lt.get(i) + "*");
                System.out.println();
            }
            throw new RuntimeException("Masyvu ilgiai turi sutapti");
        }
    }

}
