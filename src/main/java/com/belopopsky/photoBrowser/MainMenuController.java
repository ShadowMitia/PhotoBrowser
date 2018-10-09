package com.belopopsky.photoBrowser;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainMenuController extends MenuBar {

  @FXML private MenuBar mainMenu;
  @FXML private MenuItem importPhoto;
  @FXML private MenuItem deletePhoto;
  @FXML private MenuItem quitItem;

  @FXML
  void quit(ActionEvent event) {
    Stage stage = (Stage) mainMenu.getScene().getWindow();
    stage.close();

    System.out.println(mainMenu);
    System.out.println(importPhoto);
    System.out.println(deletePhoto);
    System.out.println(quitItem);
  }

  @FXML
  void importPhoto(ActionEvent event) {
    File file = new File("bat.jpg");
    Image img = new Image(file.toURI().toString());
  }

  void setPhotoRef(AnnotatedImageController con) {}
}
