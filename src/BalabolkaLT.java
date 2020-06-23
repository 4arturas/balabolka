import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.util.StringTokenizer;

public class BalabolkaLT
{
    static String txt = "54. Kaip gaunasi, kad žmonės eina skirtingais keliais?\n" +
            "\n" +
            "Iš to kas pasakyta aukščiau lengva paaiškinti, kokiu būdu, neatsižvelgiant į visų žmonių siekį į laimę, jų valia veda juos priešingomis kryptimis ir, reiškia, kai kuriuos iš jų į blogį.\n" +
            "\n" +
            "Į tai aš atsakau, kad skirtumai ir tiesioginė priešingybė renkantis tarp vieno ir kito, kurį žmonės daro šiame pasaulyje, įrodo ne tai, kad ne visi jie ieško gėrio, o tik tai, kad ne visiems vienodai tas ar kitas daiktas būna geras.\n" +
            "\n" +
            "Ši paieškų įvairovę parodo, kad ne visi priskiria savo laimę vienam ir tam pačiam ir pasirenka vieną ir tą patį kelią į laimę.\n" +
            "\n" +
            "Jei visi žmogaus interesai apsiribotų tik šiuo gyvenimu, tai to priežastis, kad vienas pasirenka mokslus, o kitas - medžioklę šunimis, vienas - prabangą ir pasileidimą, o kitas - blaivumą.\n" +
            "\n" +
            "Turtai, būtų ne tai, kad niekas iš jų ne siekia savos laimės, o tai, kad jų laimė randasi skirtinguose daiktuose. Todėl teisingas buvo daktaro atsakymas savam pacientui, kuriam skaudėjo akis: \"Jei jums labai patinka vyno skonis, nei naudotis savo regėjimu, vynas jums - gėris; jeigu jums rega sukelia daugiau malonumo, nei malonumas nuo gėrimo, vynas jums - blogis\".\n";
    public static void main( String args[] )
    {

        StringBuilder sb = new StringBuilder();
        final String folder = "55";
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
