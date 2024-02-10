package me.tjens23.searchandreplace;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable {
    private FileChooser fileChooser = new FileChooser();
    IoFacade facade = new IoFacade();

    @FXML
    private Button openFileButton;

    @FXML
    private TextField replaceField;

    @FXML
    private Button saveAsButton;

    @FXML
    private TextField searchField;

    @FXML
    private TextArea textArea;

    @FXML
    private Button clearallButton;

    @FXML
    void openFileHandler(ActionEvent event) {
        File file = fileChooser.showOpenDialog(openFileButton.getScene().getWindow());
        String text = facade.readFile(file);
        if(text.isEmpty()) {
            textArea.setText("File is empty");
        } else {
            textArea.setText(text);
        }
    }

    @FXML
    void replaceButtonHandler(ActionEvent event) {
        String search = searchField.getText();
        String replace = replaceField.getText();
        String text = textArea.getText();
        textArea.setText(text.replaceAll(search, replace));
    }

    @FXML
    void saveAsFileHandler(ActionEvent event) {
        File file = fileChooser.showSaveDialog(saveAsButton.getScene().getWindow());
        facade.writeFile(file, textArea.getText());
    }

    @FXML
    void clearAllHandler() {
        textArea.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));// Working directory
        facade = new IoFacade();
    }
}
