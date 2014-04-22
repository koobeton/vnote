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
        put("�", "=C2=A4");
        put("�", "=C2=A7");
        put("�", "=C2=A9");
        put("�", "=C2=AB");
        put("�", "=C2=AE");
        put("�", "=C2=B5");
        put("�", "=C2=BB");
        put("�", "=D0=81");
        put("�", "=D0=90");
        put("�", "=D0=91");
        put("�", "=D0=92");
        put("�", "=D0=93");
        put("�", "=D0=94");
        put("�", "=D0=95");
        put("�", "=D0=96");
        put("�", "=D0=97");
        put("�", "=D0=98");
        put("�", "=D0=99");
        put("�", "=D0=9A");
        put("�", "=D0=9B");
        put("�", "=D0=9C");
        put("�", "=D0=9D");
        put("�", "=D0=9E");
        put("�", "=D0=9F");
        put("�", "=D0=A0");
        put("�", "=D0=A1");
        put("�", "=D0=A2");
        put("�", "=D0=A3");
        put("�", "=D0=A4");
        put("�", "=D0=A5");
        put("�", "=D0=A6");
        put("�", "=D0=A7");
        put("�", "=D0=A8");
        put("�", "=D0=A9");
        put("�", "=D0=AA");
        put("�", "=D0=AB");
        put("�", "=D0=AC");
        put("�", "=D0=AD");
        put("�", "=D0=AE");
        put("�", "=D0=AF");
        put("�", "=D0=B0");
        put("�", "=D0=B1");
        put("�", "=D0=B2");
        put("�", "=D0=B3");
        put("�", "=D0=B4");
        put("�", "=D0=B5");
        put("�", "=D0=B6");
        put("�", "=D0=B7");
        put("�", "=D0=B8");
        put("�", "=D0=B9");
        put("�", "=D0=BA");
        put("�", "=D0=BB");
        put("�", "=D0=BC");
        put("�", "=D0=BD");
        put("�", "=D0=BE");
        put("�", "=D0=BF");
        put("�", "=D1=80");
        put("�", "=D1=81");
        put("�", "=D1=82");
        put("�", "=D1=83");
        put("�", "=D1=84");
        put("�", "=D1=85");
        put("�", "=D1=86");
        put("�", "=D1=87");
        put("�", "=D1=88");
        put("�", "=D1=89");
        put("�", "=D1=8A");
        put("�", "=D1=8B");
        put("�", "=D1=8C");
        put("�", "=D1=8D");
        put("�", "=D1=8E");
        put("�", "=D1=8F");
        put("�", "=D1=91");
        put("�", "=E2=82=AC");
    }

    //method that will create and return an instance
    protected static DataBase getSingleton() {

        if (uniqueDataBase == null) {
            uniqueDataBase = new DataBase();
        }
        return uniqueDataBase;
    }
}
