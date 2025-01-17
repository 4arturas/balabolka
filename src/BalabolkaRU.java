import java.io.*;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BalabolkaRU
{
    static final String end1 = "_1.wav";
    static final String end2 = "_2.wav";

    static String txt = "";

    public static void main( String args[] ) throws Exception
    {
//        scenarijus1();
//        scenarijus2("60ru", "Tatyana","Maxim" );
//        scenarijus2("60ru_", "Katya","Yuri" );

        final String destinationPath = "D:/AAA/";
        final String path = "D:\\lockelt\\21 Of Power\\";
        final String folder = "61";
        scenarijus2( destinationPath, path, folder,folder+"ru", "Tatyana", "Maxim" );
        scenarijus2( destinationPath, path, folder, folder+"ru_", "Katya", "Yuri" );
    }



    public static void scenarijus2( final String destinationPath, final String sourcePath, final String sourceFolder,
                                    final String folderName, final String titleVoice,
                                    final String bodyVoice ) throws Exception
    {
//        final String inFile = "D:\\AAA\\txt.log";
        final String inFile = sourcePath + sourceFolder + "\\"+sourceFolder+"_ru.txt";

        InputStream inputStream = new FileInputStream(inFile);
        Reader reader = new InputStreamReader(inputStream, Charset.forName("utf-8"));
        BufferedReader br = new BufferedReader( reader );
        StringBuffer sb = new StringBuffer();
        String s;
        while ( (s = br.readLine() ) != null)
        {
            sb.append( s );
            sb.append( "\n" );

        }
        br.close();
        reader.close();

        List<String> ru = new LinkedList<String>();
        split_Text( sb.toString(), ru  );



        final String usbPath = destinationPath+folderName+"/";
//        final String usbPath = "G:/John Locke/en-lt21 Of Power/"+fileNumber+"/";

        File f;
        f = new File(usbPath);
        f.mkdir();

        russian( ru, usbPath, folderName, end2, titleVoice, bodyVoice );
    }


    static void russian(List<String> l, final String path, final String folder, final String end,
                        final String titleVoice, final String bodyVoice )
    {
        int i = 1;
        String b = "D:\\Balabolka\\balcon.exe -w %s -n \"%s\" -s -4 -v 100 --silence-begin 1000 --silence-end 500 -t \"%s\"";
        for ( String s : l )
        {
            String voice;
            if (i==1||i==2)
                voice = titleVoice;
            else
                voice = bodyVoice;

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
    static void split_Text(String txt, List<String> ru )
    {
        StringTokenizer st = new StringTokenizer(txt, ".");
        int i = 0;
        while ( st.hasMoreTokens() )
        {
            String s = st.nextToken();
            s = s.trim();
            if ( s.length() == 0 )
                continue;
            s = s.replaceAll("\n", " ");
            ru.add( s );
        } // end while
    }

}
