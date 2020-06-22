import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;

public class Syllogism
{
    static String _1_1_Barbara[] = {

                    "Visi gyvūnai", "priklauso mirtingiems",
                    "visi žmonės", "priklauso gyvūnams",
                    "visi žmonės", "priklauso mirtingiems"

    };
    static String _1_2_Celarent[] = {

            "Visos reptilijos", "nepriklauso šiltakraujams",
            "visos gyvatės", "priklauso reptilijoms",
            "visos gyvatės", "nepriklauso šiltakraujams"
    };

    static String _1_3_Darii[] = {

            "Visi kiškiai", "priklauso kailiniuotiems",
            "keletas gyvūnų", "priklauso kiškiams",
            "keletas gyvūnų", "priklauso kailiniuotiems"
    };

    static String _1_4_Ferioque[] = {

                    "Visi namų darbai", "nepriklauso pramogoms",
                    "keletas skaytymų", "priklauso namų darbams",
                    "keletas skaytymų", "nepriklauso pramogoms"

    };



    static String _2_1_Cesare[] = {

                    "Visi sveiki maistai", "nepriklauso storinantiems",
                    "visi tortai", "priklauso storinantiems",
                    "visi tortai", "nepriklauso sveikiems maistams"

    };

    static String _2_2_Camestres[] = {

                    "Visi arkliai", "priklauso išpūstapilviams",
                    "visi žmonės", "nepriklauso išpūstapilviams",
                    "visi žmonės", "nepriklauso arkliams"

    };

    static String _2_3_Festino[] = {

            "Visi tinginiai", "nepriklauso išlaikantiems egzaminus",
            "keletas studentų", "priklauso išlaikantiems egzaminus",
            "keletas studentų", "nepriklauso tinginiams"

    };

    static String _2_4_Baroco[] = {

            "Visi informatyvūs daiktai", "priklauso naudingiems",
            "keletas knygų", "nepriklauso naudingiems",
            "keletas knygų", "nepriklauso informatyviems daiktams"

    };

    static String _2_5_Camestros[] = {

            "Visi arkliai", "priklauso išpūstapilviams",
            "keletas žmonių", "nepriklauso išpūstapilviams",
            "keletas žmonių", "nepriklauso arkliams"

    };

    static String _3_1_Darapti[] = {

            "Visi vaisiai", "priklauso maistingiems",
            "keletas vaisių", "priklauso skaniems",
            "keletas produktų", "priklausantys skaniems", "priklauso maistingiems"

    };

    static String _3_2_Disamis[] = {

            "keletas ratukų", "priklauso gražiems",
            "visi ratukai", "priklauso naudingiems",
            "keletas daiktų", "priklausantys naudingiems", "priklauso gražiems"

    };

    static String _3_3_Datisi[] = {

            "visi geri berniukai šioje mokykloje", "priklauso pionieriams",
            "keletas berniukų šioje mokykloje", "priklauso sportininkams",
            "keletas daiktų", "priklausantys sportininkams", "priklauso pionieriams"

    };

    static String _3_4_Felapton[] = {

            "visi ąsočiai šioje spintoje", "priklauso seniems",
            "visi ąsočiai šioje spintoje", "priklauso suskilusiems",
            "visi daiktai šioje spintoje", "priklausantys suskilusiems", "priklauso seniems"

    };

    static String _3_5_Bocardo[] = {

            "keletas kačių", "priklauso beuodegėms",
            "visos katės", "priklauso žinduoliams",
            "keletas žinduolių", "priklauso beuodegiams"

    };


    static String _3_6_Ferison[] = {

            "visi medžiai", "priklauso nevalgomiems",
            "keletas medžių", "priklauso žaliems",
            "visi augalai priklausantys žaliems", "priklauso nevalgomiems"

    };

    static String _4_1_Bramantip[] = {

            "visi obuoliai mano sode", "priklauso naudingiems",
            "visi vaisiai priklausantys naudingiems", "priklauso prinokusiems",
            "keletas vaisių priklausančių prinokusiems", "priklauso obuoliams mano sode"

    };

    static String _4_2_Camenes[] = {
            "visos ryškios gėlės", "priklauso kvepenčioms",
            "visos ryškios gėlės", "nepriklauso kambarinėms",
            "visos kambarinės gėlės", "nepriklauso kvepenčioms gėlėms"
    };

    static String _4_3_Dimaris[] = {
            "keletas mažų paukščių", "priklauso valgantiems medų",
            "visi valgantys medų paukščiai", "priklauso spalvotiems",
            "keletas spalvotų paukščių", "priklauso mažiems"
    };

    static String _4_4_Fesapo[] = {
            "visi žmonės", "nepriklauso tobuliems",
            "visos tobulos būtybės", "priklauso mifinėms",
            "keletas mifinių būtybių", "nepriklauso žmonėms"
    };

    static String _4_5_Fresison[] = {
            "visi kompetetingi žmonės", "nepriklauso klystantiems",
            "keletas klystančių žmonių", "priklauso čia dirbantiems",
            "keletas čia dirbančių žmonių", "nepriklauso kompetetingiems"
    };

    static String _4_6_Camenos[] = {
            "visos ryškios gėlės", "priklauso kvepenčioms",
            "visos kvepiančios gėlės", "nepriklauso išaugintoms patalpose",
            "keletas išaugintų patalpose", "nepriklauso ryškioms"
    };

    static int figuraNr = 1;
    static void make( StringBuilder b, final String figurosPavadinimas, final String figura[] )
    {
        final String folder = path + "/"+ figurosPavadinimas;

        File f = new File(folder);
        f.mkdir();

        final String pathPattern = folder + "/%s%s.wav";

        final String strFiguraNr = addZero( figuraNr );
        int fileNr = 0;

        String path = String.format(pathPattern, strFiguraNr, addZero( fileNr++ ) );

        /*b.append( "sound_Init( Regina );");
        b.append( String.format("sound_Save( \"%s\", \"%s\" );", path, figurosPavadinimas ) );
        b.append("sound_Destroy();");*/

        String balcon = "D:\\Balabolka\\balcon.exe -w %s -n \"%s\" -s -4 -v 100 --silence-begin 1000 --silence-end 500 -t \"%s\"";
        String sBalcon = String.format( balcon, path, "Emma", figurosPavadinimas);
//            System.out.println( sBalcon );
        try {
            Runtime.getRuntime().exec(sBalcon);
        }
        catch (IOException e) {
            e.printStackTrace();
        };

        for ( String s : figura )
        {
            s = s.toLowerCase();
            if ( s.contains("visi") || s.contains("visos") )
            {
                b.append( "sound_Init( Regina );");
            }
            else if ( s.contains("nepriklauso") || s.contains("nepriklausantys") || s.contains("nepriklausančios") || s.contains("nepriklausančių") )
            {
                b.append( "sound_Init( Aiste );");
            }
            else if ( s.contains("keletas") )
            {
                b.append( "sound_Init( Edvardas );");
            }
            else if ( s.contains("priklauso") || s.contains("priklausantys") || s.contains("priklausančios") || s.contains("priklausančių") )
            {
                b.append( "sound_Init( Vladas );");
            }

            path = String.format(pathPattern, strFiguraNr, addZero( fileNr++ ) );

            b.append( String.format("sound_Save( \"%s\", \"%s\" );", path, s ) );
            b.append("sound_Destroy();");

        }
        figuraNr++;
    }
    static String addZero( final int n )
    {
        String s = "" + n;
        if ( (s).length() == 1 )
            return "0" + n;
        return s;
    }
    final static String path = "D:/AAA/syllogism";
    public static void main(String[] args)
    {
        File f = new File(path);
        f.mkdir();

        StringBuilder b = new StringBuilder();

/*
        make( b, "Barbara", _1_1_Barbara);
        make( b, "Celarent", _1_2_Celarent);
        make( b, "Darii", _1_3_Darii);
        make( b, "Ferioque", _1_4_Ferioque);
*/

/*
        make( b, "Cesare", _2_1_Cesare);
        make( b, "Camestres", _2_2_Camestres);
        make( b, "Festino", _2_3_Festino);
        make( b, "Baroco", _2_4_Baroco);
        make( b, "Camestros", _2_5_Camestros);
*/

/*
        make( b, "Darapti", _3_1_Darapti);
        make( b, "Disamis", _3_2_Disamis);
        make( b, "Datisi", _3_3_Datisi);
        make( b, "Felapton", _3_4_Felapton);
        make( b, "Bocardo", _3_5_Bocardo);
        make( b, "Ferison", _3_6_Ferison);
*/


//        make( b, "Bramantip", _4_1_Bramantip);
//        make( b, "Camenes", _4_2_Camenes);
//        make( b, "Dimaris", _4_3_Dimaris);
//        make( b, "Fesapo", _4_4_Fesapo);
        make( b, "Fresison", _4_5_Fresison);
//        make( b, "Camenos", _4_6_Camenos);


        StringSelection stringSelection = new StringSelection(b.toString());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        System.out.println( b );
    }
}
