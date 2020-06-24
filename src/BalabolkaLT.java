import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.util.StringTokenizer;

public class BalabolkaLT
{
    static String txt = "56. Visi žmonės ieško laimės, bet ne tos pačios.\n" +
            "\n" +
            "Protas turi skirtingus polinkius, taip pat kaip ir gomurys.\n" +
            "\n" +
            "Bandymas patenkinti visus žmones turtais arba garbe(kurią kai kurie žmonės priskiria sava laime) pasirodys tokia pat tuščia, kaip ir bandymas patenkinti jų alki sūriu arba omarais.\n" +
            "\n" +
            "Nors kai kuriems šie patiekalai atrodo maloniais ir nuostabiais, kitiems jie sukelia smarkų pasišlykštėjimą; dauguma ne be pagrindo pasitenkintų spazmais alkaname skrandyje, kurie kitiems atrodo didžiausias pasitenkinimas.\n" +
            "\n" +
            "Tame ir randasi priežastis, kodėl senovės filosofų tyrimai buvo atlikti veltui, ar didžiausias gėris yra turte, ar kūniškuose malonumuose, ar dorybėje, ar mąstyme.\n" +
            "\n" +
            "Su tokia pat teise jie galėtų ginčytis ir skirstytis į mokyklas pagal klausimus apie tai, kas iš visų skaniausi: obuoliai, slyvos arba riešutai.\n" +
            "\n" +
            "Nes, ne nuo daiktų priklauso koks malonus yra skonis, o nuo to ar kito gomurio patrauklumo, tame galime stebėti didelę įvairovę, taip ir aukščiausia laimė yra daiktų, suteikiančių didžiausią malonumą turėjime, ir daiktų, sukeliančių  kažkokį nepasitenkinimą neturėjime, kažkokią kančia.\n" +
            "\n" +
            "O skirtingiems žmonėms jie skirtingi.\n" +
            "\n" +
            "Jeigu todėl žmonės dėtų viltis tik į šį gyvenimą, jeigu jie galėtų mėgautis tik jame, tai ne būtų nieko keisto ir neprotingo tame, kad jie ieškotų savos laimės tame, kad išvengti viso to, kas sukelia jiems čia skausmą, ir siekyje link viso to, kas tenkina juos, ir nėra nieko nuostabaus, kad mes randame čia įvairovę ir skirtumą.\n" +
            "\n" +
            "Jeigu už kapo nieko nesimato, tada, aišku, teisinga išvada: \"ar valgysime ir gersime\", mėgausime tuo, kas mums malonu, \"nes rytoj numirsime\".\n" +
            "\n" +
            "Man atrodo, tai gali išaiškinti mums, kodėl ne visi skatinami vienu ir tuo pačiu objektu, nors visų norai nukreipti į laimę.\n" +
            "\n" +
            "Žmonės gali pasirinkti skirtingus daiktus ir vis gi pasirinkti teisingai, jeigu tik tarti, kad jie panašūs į apgailėtinų vabzdžių visuomenę, vieni iš kurių - bitės mėgaujasi gėlėmis ir jų saldumu, kiti - vabalai mėgaujasi kitu maistu, o pasitenkinę tuo tam tikrą laiko tarpą, visi jie nustoja būti ir nuo tada daugiau niekada neegzistuoja.\n";
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
