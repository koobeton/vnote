import java.util.HashMap;

/**
 * Singleton
 */
class DataBase extends HashMap<String, String> {

    //static variable that contains unique instance
    private static DataBase uniqueDataBase;

    //private constructor
    private DataBase() {

        //EOL
        put(System.lineSeparator(), "=0A");
        put("\n", "=0A");

        put(" ", " ");
        put("!", "!");
        put("\"", "\"");
        put("#", "#");
        put("$", "$");
        put("%", "%");
        put("&", "&");
        put("'", "'");
        put("(", "(");
        put(")", ")");
        put("*", "*");
        put("+", "+");
        put(",", ",");
        put("-", "-");
        put(".", ".");
        put("/", "/");
        put("0", "0");
        put("1", "1");
        put("2", "2");
        put("3", "3");
        put("4", "4");
        put("5", "5");
        put("6", "6");
        put("7", "7");
        put("8", "8");
        put("9", "9");
        put(":", ":");
        put(";", ";");
        put("<", "<");
        put("=", "=3D");
        put(">", ">");
        put("?", "?");
        put("@", "@");
        put("A", "A");
        put("B", "B");
        put("C", "C");
        put("D", "D");
        put("E", "E");
        put("F", "F");
        put("G", "G");
        put("H", "H");
        put("I", "I");
        put("J", "J");
        put("K", "K");
        put("L", "L");
        put("M", "M");
        put("N", "N");
        put("O", "O");
        put("P", "P");
        put("Q", "Q");
        put("R", "R");
        put("S", "S");
        put("T", "T");
        put("U", "U");
        put("V", "V");
        put("W", "W");
        put("X", "X");
        put("Y", "Y");
        put("Z", "Z");
        put("[", "[");
        put("\\", "\\");
        put("]", "]");
        put("^", "^");
        put("_", "_");
        put("`", "`");
        put("a", "a");
        put("b", "b");
        put("c", "c");
        put("d", "d");
        put("e", "e");
        put("f", "f");
        put("g", "g");
        put("h", "h");
        put("i", "i");
        put("j", "j");
        put("k", "k");
        put("l", "l");
        put("m", "m");
        put("n", "n");
        put("o", "o");
        put("p", "p");
        put("q", "q");
        put("r", "r");
        put("s", "s");
        put("t", "t");
        put("u", "u");
        put("v", "v");
        put("w", "w");
        put("x", "x");
        put("y", "y");
        put("z", "z");
        put("{", "{");
        put("|", "|");
        put("}", "}");
        put("~", "~");
        put("¤", "=C2=A4");
        put("§", "=C2=A7");
        put("©", "=C2=A9");
        put("«", "=C2=AB");
        put("®", "=C2=AE");
        put("µ", "=C2=B5");
        put("»", "=C2=BB");
        put("¨", "=D0=81");
        put("À", "=D0=90");
        put("Á", "=D0=91");
        put("Â", "=D0=92");
        put("Ã", "=D0=93");
        put("Ä", "=D0=94");
        put("Å", "=D0=95");
        put("Æ", "=D0=96");
        put("Ç", "=D0=97");
        put("È", "=D0=98");
        put("É", "=D0=99");
        put("Ê", "=D0=9A");
        put("Ë", "=D0=9B");
        put("Ì", "=D0=9C");
        put("Í", "=D0=9D");
        put("Î", "=D0=9E");
        put("Ï", "=D0=9F");
        put("Ğ", "=D0=A0");
        put("Ñ", "=D0=A1");
        put("Ò", "=D0=A2");
        put("Ó", "=D0=A3");
        put("Ô", "=D0=A4");
        put("Õ", "=D0=A5");
        put("Ö", "=D0=A6");
        put("×", "=D0=A7");
        put("Ø", "=D0=A8");
        put("Ù", "=D0=A9");
        put("Ú", "=D0=AA");
        put("Û", "=D0=AB");
        put("Ü", "=D0=AC");
        put("İ", "=D0=AD");
        put("Ş", "=D0=AE");
        put("ß", "=D0=AF");
        put("à", "=D0=B0");
        put("á", "=D0=B1");
        put("â", "=D0=B2");
        put("ã", "=D0=B3");
        put("ä", "=D0=B4");
        put("å", "=D0=B5");
        put("æ", "=D0=B6");
        put("ç", "=D0=B7");
        put("è", "=D0=B8");
        put("é", "=D0=B9");
        put("ê", "=D0=BA");
        put("ë", "=D0=BB");
        put("ì", "=D0=BC");
        put("í", "=D0=BD");
        put("î", "=D0=BE");
        put("ï", "=D0=BF");
        put("ğ", "=D1=80");
        put("ñ", "=D1=81");
        put("ò", "=D1=82");
        put("ó", "=D1=83");
        put("ô", "=D1=84");
        put("õ", "=D1=85");
        put("ö", "=D1=86");
        put("÷", "=D1=87");
        put("ø", "=D1=88");
        put("ù", "=D1=89");
        put("ú", "=D1=8A");
        put("û", "=D1=8B");
        put("ü", "=D1=8C");
        put("ı", "=D1=8D");
        put("ş", "=D1=8E");
        put("ÿ", "=D1=8F");
        put("¸", "=D1=91");
        put("ˆ", "=E2=82=AC");
    }

    //method that will create and return an instance
    protected static DataBase getSingleton() {

        if (uniqueDataBase == null) {
            uniqueDataBase = new DataBase();
        }
        return uniqueDataBase;
    }
}
