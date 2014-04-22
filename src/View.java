import javax.swing.*;
import java.awt.TextArea;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;

class View {

    private TextArea inputText;
    private TextArea outputText;
    private JButton convertButton;
    private JLabel statusString;

    protected View(Converter parentLink) {

        final Color DEFAULT_BACKGROUND = Color.LIGHT_GRAY;

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFrame window = new JFrame("Создание заметок vNote.vnt");
        window.setLayout(new BorderLayout());
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(1000, 550);

        JLabel inputTextLabel = new JLabel("Текст:");
        inputText = new TextArea(null, 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        JLabel outputTextLabel = new JLabel("vNote.vnt:");
        outputText = new TextArea(null, 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        convertButton = new JButton("Конвертировать и сохранить");
        statusString = new JLabel();

        GridLayout grid = new GridLayout(1, 2);
        JPanel topPanel = new JPanel(grid);
        JPanel centerPanel = new JPanel(grid);
        JPanel bottomPanel = new JPanel(new GridLayout(2, 1));

        //setting properties for essential window elements
        outputText.setEditable(false);
        outputText.setFocusable(false);
        outputText.setBackground(DEFAULT_BACKGROUND);
        bottomPanel.setBackground(DEFAULT_BACKGROUND);

        topPanel.add(inputTextLabel);
        topPanel.add(outputTextLabel);
        centerPanel.add(inputText);
        centerPanel.add(outputText);
        bottomPanel.add(convertButton);
        bottomPanel.add(statusString);

        window.add("North", topPanel);
        window.add("Center", centerPanel);
        window.add("South", bottomPanel);

        convertButton.addActionListener(parentLink);

        window.setVisible(true);
    }

    protected String getInputText() {

        return inputText.getText();
    }

    protected void setOutputText(String newText) {

        outputText.setText(newText);
    }

    protected void setStatusString(String newText) {

        statusString.setText(newText);
    }
}
