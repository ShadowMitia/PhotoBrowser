package com.belopopsky.photoBrowser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MainMenuController {

  @FXML private MenuBar mainMenu;
  @FXML private MenuItem importPhoto;
  @FXML private MenuItem deletePhoto;
  @FXML private MenuItem quitItem;

  @FXML
  void quit(ActionEvent event) {
    Stage stage = (Stage) mainMenu.getScene().getWindow();
    stage.close();
  }
}
