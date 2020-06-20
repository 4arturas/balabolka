import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;

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
            "keletas vaisiai", "priklauso skaniems",
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
            "visi augalų", "priklausantys žaliems", "priklauso nevalgomiems"

    };

    static String _4_1_Bramantip[] = {

            "visi obuoliai mano sode", "priklauso naudingiems",
            "visi vaisiai", "priklausantys naudingiems", "priklauso prinokusiems",
            "keletas vaisių", "priklausantys prinokusiems", "priklauso obuoliams mano sode"

    };

    static String _4_2_Camenes[] = {

            "visi ryškios gėlės", "priklauso kvepenčioms",
            "visos ryškios gėlės", "nepriklauso kambarinėms",
            "visos ryškios gėlės", "priklausančios kambarinėms", "nepriklauso kvepenčioms"

    };

    static int figuraNr = 1;
    static void make( StringBuilder b, final String figurosPavadinimas, final String figura[] )
    {
        final String pathPattern = path + "/%s%s.wav";
        final String strFiguraNr = addZero( figuraNr );
        int fileNr = 0;

        b.append( "sound_Init( Regina );");
        String path = String.format(pathPattern, strFiguraNr, addZero( fileNr++ ) );
        b.append( String.format("sound_Save( \"%s\", \"%s\" );", path, figurosPavadinimas ) );

        for ( String s : figura )
        {
            s = s.toLowerCase();
            if ( s.contains("visi") || s.contains("visos") )
                b.append( "sound_Init( Regina );");
            else if ( s.contains("keletas") )
                b.append( "sound_Init( Edvardas );");
            else if ( s.contains("priklauso") || s.contains("priklausantys")  || s.contains("priklausančios") )
                b.append( "sound_Init( Vladas );");
            else if ( s.contains("nepriklauso") )
                b.append( "sound_Init( Aiste );");

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
        make( b, "Barbara", _1_1_Barbara);
        make( b, "Celarent", _1_2_Celarent);
        make( b, "Darii", _1_3_Darii);
        make( b, "Ferioque", _1_4_Ferioque);

        make( b, "Cesare", _2_1_Cesare);
        make( b, "Camestres", _2_2_Camestres);
        make( b, "Festino", _2_3_Festino);
        make( b, "Baroco", _2_4_Baroco);
        make( b, "Camestros", _2_5_Camestros);

        make( b, "Darapti", _3_1_Darapti);
        make( b, "Disamis", _3_2_Disamis);
        make( b, "Datisi", _3_3_Datisi);
        make( b, "Felapton", _3_4_Felapton);
        make( b, "Bocardo", _3_5_Bocardo);
        make( b, "Ferison", _3_6_Ferison);

        make( b, "Bramantip", _4_1_Bramantip);
        make( b, "Camenes", _4_2_Camenes);


        StringSelection stringSelection = new StringSelection(b.toString());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        System.out.println( b );
    }
}
