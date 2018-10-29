package com.belopopsky.photoBrowser;

import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javafx.scene.control.DialogPane;

import javafx.stage.StageStyle;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;



public class MainMenuController extends MenuBar {

    @FXML private MenuBar mainMenu;
    @FXML private MenuItem importPhoto;
    @FXML private MenuItem deletePhoto;
    @FXML private MenuItem quitItem;
    @FXML private MenuItem aboutItem;

    private App app;

    void setApp(App app) {
        this.app = app;
    }

  @FXML
  void quit(ActionEvent event) {
    Stage stage = (Stage) mainMenu.getScene().getWindow();
    stage.close();
  }

    @FXML
    void importPhoto() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home") + File.separator + "Pictures"));
        fileChooser.setTitle("Open Image File");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        Stage stage = (Stage) mainMenu.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            Image img = new Image(selectedFile.toURI().toString());
            this.app.importPhoto(img);
        }
    }

    @FXML
    void showAboutWindow(ActionEvent event) {
        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("About");
        dialog.initStyle(StageStyle.UTILITY);
        dialog.setContentText("Made by Dimitri Belopopsky\n\nhttp://github.com/ShadowMitia/PhotoBrowser");
        ButtonType closeButton = new ButtonType("Close", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(closeButton);
        dialog.setResultConverter(dialogButton -> { return null; });
        dialog.show();
    }
}


