import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Converter extends Application {

    private final static String VNOTE_HEADER = "BEGIN:VNOTE";
    private final static String VNOTE_BODY = "BODY;CHARSET=UTF-8;ENCODING=QUOTED-PRINTABLE:";
    private final static String VNOTE_FOOTER = "END:VNOTE";
    private final static String DEFAULT_FILE_NAME = "vNote.vnt";
    private final static double GAP = 5;
    private final static int WINDOW_WIDTH = 1050;
    private final static int WINDOW_HEIGHT = 550;
    private final static String ICON = "styles/icon.png";

    private DataBase dataBase;
    private TextArea inputText;
    private TextArea outputText;
    private Text statusString;

    public static void main(String... args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) {

        //getting Singleton
        dataBase = DataBase.getSingleton();

        //create window elements
        inputText = new TextArea();
        outputText = new TextArea() {
            //setFocusable(false):
            @Override
            public void requestFocus() {}
        };
        Button convertButton = new Button("Сохранить");
        statusString = new Text();
        Text inputTextLabel = new Text("Текст:");
        Text outputTextLabel = new Text("vNote.vnt:");

        //setting properties for essential window elements
        inputText.setWrapText(true);
        outputText.setWrapText(true);
        outputText.setEditable(false);

        //layouts
        BorderPane border = new BorderPane();
        GridPane grid = new GridPane();
        AnchorPane anchor = new AnchorPane();

        //grid pane
        grid.addRow(0, inputTextLabel, outputTextLabel);
        grid.addRow(1, inputText, outputText);
        //allow grid pane to grows to all available space when resize
        //set same width to both columns
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(50);  //column get 50% of width
        grid.getColumnConstraints().addAll(columnConstraints, columnConstraints); //each column get 50% of width
        //set no grows to labels row and full grows to text area's row
        ArrayList<RowConstraints> rowConstraints = new ArrayList<>();
        rowConstraints.add(new RowConstraints());
        rowConstraints.add(new RowConstraints());
        rowConstraints.get(0).setVgrow(Priority.NEVER);
        rowConstraints.get(1).setVgrow(Priority.ALWAYS);
        grid.getRowConstraints().addAll(rowConstraints);
        //set padding and spacing
        grid.setPadding(new Insets(GAP));
        grid.setHgap(GAP);

        //anchor pane
        anchor.getChildren().addAll(statusString, convertButton);
        AnchorPane.setLeftAnchor(statusString, GAP);    //with padding
        AnchorPane.setBottomAnchor(statusString, GAP);
        AnchorPane.setRightAnchor(convertButton, GAP);
        AnchorPane.setBottomAnchor(convertButton, GAP);

        //border pane
        border.setCenter(grid);
        border.setBottom(anchor);

        //stage
        stage.setScene(new Scene(border));
        stage.setWidth(WINDOW_WIDTH);
        stage.setHeight(WINDOW_HEIGHT);
        stage.setMinWidth(WINDOW_WIDTH / 2);
        stage.setMinHeight(WINDOW_HEIGHT / 2);
        stage.setTitle("Создание заметок vNote.vnt");
        stage.getIcons().add(new Image(this.getClass().getResource(ICON).toExternalForm()));
        stage.show();

        //button click handler
        convertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                convert();
            }
        });
    }

    private void convert() {

        File outputFile = new File(DEFAULT_FILE_NAME);
        try (BufferedWriter outputBuffer = new BufferedWriter(new FileWriter(outputFile))) {

            String sourceText = inputText.getText();
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
            outputText.setText(convertedText);
            statusString.setText(outputFile.getAbsolutePath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
