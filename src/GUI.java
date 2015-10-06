import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class GUI extends Application {

    private final static String DEFAULT_FILE_NAME = "vNote.vnt";
    private final static double GAP_ANCHOR = 0;
    private final static int WINDOW_WIDTH = 1050;
    private final static int WINDOW_HEIGHT = 550;
    private final static String APP_ICON = "styles/app_icon.png";
    private final static String CSS = "styles/styles.css";

    private TextArea inputText;
    private TextArea outputText;
    private Hyperlink statusString;
    private File outputFile = null;

    public static void main(String... args) {

        launch(args);
    }

    @Override
    public void start(final Stage stage) {

        //create window elements
        Label inputTextLabel = new Label("Текст:");
        Label outputTextLabel = new Label("vNote.vnt:");
        inputText = new TextArea();
        outputText = new TextArea() {
            //setFocusable(false):
            @Override
            public void requestFocus() {}
        };
        Button convertButton = new Button("Сохранить");
        statusString = new Hyperlink();

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

        //anchor pane
        anchor.getChildren().addAll(statusString, convertButton);
        AnchorPane.setLeftAnchor(statusString, GAP_ANCHOR);    //padding set in CSS
        AnchorPane.setBottomAnchor(statusString, GAP_ANCHOR);
        AnchorPane.setRightAnchor(convertButton, GAP_ANCHOR);
        AnchorPane.setBottomAnchor(convertButton, GAP_ANCHOR);

        //border pane
        border.setCenter(grid);
        border.setBottom(anchor);

        //scene and CSS
        Scene scene = new Scene(border);
        scene.getStylesheets().add(CSS);
        border.getStyleClass().add("border");
        grid.getStyleClass().add("grid");
        anchor.getStyleClass().add("anchor");
        inputTextLabel.setId("input-text-label");
        outputTextLabel.setId("output-text-label");
        outputText.setId("output-text");
        convertButton.setId("save-btn");

        //stage
        stage.setScene(scene);
        stage.setWidth(WINDOW_WIDTH);
        stage.setHeight(WINDOW_HEIGHT);
        stage.setMinWidth(WINDOW_WIDTH / 2);
        stage.setMinHeight(WINDOW_HEIGHT / 2);
        stage.setTitle("Создание заметок vNote.vnt");
        stage.getIcons().add(new Image(getClass().getResource(APP_ICON).toExternalForm()));
        stage.show();

        //button click handler
        convertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                convert();
            }
        });

        //hyperlink click handler
        statusString.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //check the output file exists
                if (outputFile != null) {
                    //getting parent directory name as a File object
                    File outputFileDirectory = new File(
                            outputFile.getAbsolutePath().replaceAll(outputFile.getPath() + "$", "")); //$ - EOL regexp
                    //check this File object is a directory
                    if (outputFileDirectory.isDirectory()) {
                        openDirectory(outputFileDirectory, stage);
                    }
                }
            }
        });
    }

    private void convert() {

        outputFile = new File(DEFAULT_FILE_NAME);
        try (BufferedWriter outputBuffer = new BufferedWriter(new FileWriter(outputFile))) {

            String convertedText = Converter.convert(inputText.getText());

            outputBuffer.write(convertedText);
            outputText.setText(convertedText);
            statusString.setId("hyperlink-normal");
            statusString.setText(outputFile.getAbsolutePath());
        } catch (FileNotFoundException ex) {
            //check if file name match the directory name
            if (outputFile.isDirectory()) {
                String wrongName = outputFile.getPath();
                statusString.setId("hyperlink-warning");
                statusString.setText("ОШИБКА: Невозможно создать файл " + wrongName + ".\n" +
                        "Текущая папка содержит вложенную папку с таким именем.\n " +
                        "Для продолжения работы переименуйте папку " + wrongName + ".");
            } else ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void openDirectory(File directory, Stage ownerWindow) {

        FileChooser explorer = new FileChooser();
        explorer.setTitle("Менеджер файлов vNote");
        explorer.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Файлы vNote", "*.vnt"),
                new FileChooser.ExtensionFilter("Все файлы", "*.*"));
        explorer.setInitialDirectory(directory);
        explorer.showOpenDialog(ownerWindow);
    }
}
