import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Converter implements ActionListener {

    private final static String VNOTE_HEADER = "BEGIN:VNOTE";
    private final static String VNOTE_BODY = "BODY;CHARSET=UTF-8;ENCODING=QUOTED-PRINTABLE:";
    private final static String VNOTE_FOOTER = "END:VNOTE";
    private final static String DEFAULT_FILE_NAME = "vNote.vnt";
    private DataBase dataBase;
    private View view;

    private Converter() {

        //getting Singleton
        dataBase = DataBase.getSingleton();

        view = new View(this);
    }

    public static void main(String[] args) {

        new Converter();
    }

    public void actionPerformed(ActionEvent evnt) {

        File outputFile = new File(DEFAULT_FILE_NAME);
        try (BufferedWriter outputBuffer = new BufferedWriter(new FileWriter(outputFile))) {

            String sourceText = view.getInputText();
            String convertedText;

            //writing HEADER
            convertedText = VNOTE_HEADER;
            convertedText += System.lineSeparator();
            //writing BODY
            convertedText += VNOTE_BODY;
            for (int i = 0; i < sourceText.length(); i++) {
                String symbol = String.valueOf(sourceText.charAt(i));
                if (dataBase.containsKey(symbol)) {
                    convertedText += dataBase.get(symbol);
                }
            }
            convertedText += System.lineSeparator();
            //writing FOOTER
            convertedText += VNOTE_FOOTER;
            convertedText += System.lineSeparator();

            outputBuffer.write(convertedText);
            view.setOutputText(convertedText);
            view.setStatusString(outputFile.getAbsolutePath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
