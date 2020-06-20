import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.util.StringTokenizer;

public class BalabolkaLT
{
    static String txt = "53. To priežastis.\n" +
            "\n" +
            "Tokia yra ta ašis, aplink kurią sukasi protingų būtybių laisvė, tai yra pastovis tikros palaimos siekis ir pastovios jos paieškos, taip, kad jie gali atskiruose atvejuose atidėti šias paieškas tiek, kol ne apsižvalgys ir negaus informacijos, ar nėra tariamas arba trokštamas jiems tam tikras daiktas kelyje į pagrindinį tikslą ir ar sudaro ji realią dalį to, kas yra jų aukščiausias gėris.\n" +
            "\n" +
            "Juk jų prigimties polinkis ir siekis į laimę yra jiems būtinybė ir paskata rūpintis apie tai, kad ne padaryti klaidos arba ne praleisti jos, ir tokiu būdu ji būtinai priverčia juos būti atsargiems, mąstantiems ir apžvalgiems savų atskirų veiksmų kryptyje kaip priemonė siekiant aukščiausio gėrio.\n" +
            "\n" +
            "Ta pati būtinybė, kuri priverčia mus siekti tikrosios palaimos, su tokia pačia jėga verčia palaukti, apgalvoti ir tyrinėti kiekvieno nuoseklaus noro, kad jo patenkinimas nekenktų mūsų tikrai laimei ir nenutolintų mus nuo jos.\n" +
            "\n" +
            "Tame, mano nuomone, yra didelis baigtinių protingų būtybių privalumas.\n" +
            "\n" +
            "Ir aš norėčiau, kad dėmesingai ištyrinėtų klausimą, ar tik nėra gilus šaltinis ir galimybė panaudoti visą tą laisvę, kurią žmonės turi, kurią tik sugeba turėti, kokia gali būti jiems naudinga ir nuo kurios priklauso jų veiksmų kaita, tame, kad žmonės gali atidėti savus troškimus ir suspenduoti juos nuo to, kad sąlygoti valią kažkuriam veiksmui, iki jie ne apžvelgs tinkamu būdu ir nešališkai jo gėrį ir blogį, kai to reikalauja užduoties svarba.\n" +
            "\n" +
            "Tai mes galime padaryti.\n" +
            "\n" +
            "Atlikę tai, mes įvykdėme savo pareigą ir visą tai, kas mūsų valdžioje, ir visa tai, ko tikrai reikia.\n" +
            "\n" +
            "Nes valia numato žinojimą savo pasirinkimo valdymu, tai viską, kas mes galime padaryt - tai ne sąlygoti savo valios, ne ištyrę gerų ir blogų savo noro objekto pusių.\n" +
            "\n" +
            "Kas bus po to, eis surišta viena su kita išvadų grandine, priklausančių nuo paskutinio sprendimo nutarties\n" +
            "\n" +
            "Mūsų valdžioje padaryti tai po skuboto ir atsainaus žvilgsnio arba po tinkamo ir brandaus ištyrimo, nes patirtis rodo mums, kad daugelyje atvejų mes galime atidėti greitą bet kokio troškimo patenkinimą.";
    public static void main( String args[] )
    {

        StringBuilder sb = new StringBuilder();
        make( sb,"D:/AAA/53/", "Regina", "Vladas" );
        make( sb,"D:/AAA/53_/", "Edvardas", "Aiste" );

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
