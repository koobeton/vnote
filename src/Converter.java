import java.nio.charset.StandardCharsets;

public class Converter {

    private static final String VNOTE_HEADER = "BEGIN:VNOTE";
    private static final String VNOTE_BODY = "BODY;CHARSET=UTF-8;ENCODING=QUOTED-PRINTABLE:";
    private static final String VNOTE_FOOTER = "END:VNOTE";

    public static String convert(String source) {

        StringBuilder convertedText = new StringBuilder();

        //writing HEADER
        convertedText.append(VNOTE_HEADER);
        convertedText.append(System.lineSeparator());
        //writing BODY
        convertedText.append(VNOTE_BODY);
        for (char c : source.toCharArray()) {
            String symbol = String.valueOf(c);
            byte[] bytes = symbol.getBytes(StandardCharsets.UTF_8);
            if (symbol.equals(System.lineSeparator()) || symbol.equals("\n")) {
                convertedText.append("=0A");
            } else if (symbol.equals("=")) {
                convertedText.append("=3D");
            } else if (bytes.length == 1) {
                convertedText.append(symbol);
            } else {
                for (byte b : bytes) {
                    convertedText.append(String.format("=%02x", b).toUpperCase());
                }
            }
        }
        convertedText.append(System.lineSeparator());
        //writing FOOTER
        convertedText.append(VNOTE_FOOTER);
        convertedText.append(System.lineSeparator());

        return convertedText.toString();
    }
}
