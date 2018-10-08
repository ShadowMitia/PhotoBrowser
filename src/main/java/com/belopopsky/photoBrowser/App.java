package com.belopopsky.photoBrowser;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** Hello world! */
public class App extends Application {
  public static void main(String[] args) {
    Application.launch(args);
  }

  /* The high level container of all the GUI elements */
  Stage stage;

  FXMLLoader loader;

  @FXML private AnnotatedImageController annotatedImageController;
  @FXML private MainMenuController mainMenuController;

  /* Entry point */
  @Override
  public void start(Stage stage0) throws Exception {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("/PhotoBrowserScene.fxml"));
    Parent root = loader.load();

    stage = stage0;

    stage0.setTitle("jPhoto Browser 2018 MASTER DELUXE (jLife package)");
    stage0.setMinWidth(500);
    stage0.setMinHeight(500);
    stage0.setScene(new Scene(root, 500, 500));
    stage0.sizeToScene();
    stage0.setMinWidth(300);
    stage0.setMinHeight(500);

    stage0.show();
  }
}
