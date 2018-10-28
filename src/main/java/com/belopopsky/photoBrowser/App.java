package com.belopopsky.photoBrowser;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;

/** Hello world! */
public class App extends Application {
  public static void main(String[] args) {
    Application.launch(args);
  }

  /* The high level container of all the GUI elements */
  Stage stage;
    /* Controllers */
    MainMenuController mainMenuController;
    AnnotatedImageController annotatedImageController;

  /* Entry point */
  @Override
  public void start(Stage stage0) throws Exception {

      stage = stage0;

      /* Define all FXML files to load */
      /* Short form exists, but never really worked reliably for this project */
      FXMLLoader mainMenuLoader = new FXMLLoader();
      mainMenuLoader.setLocation(getClass().getResource("/MainMenu.fxml"));

      FXMLLoader annotatedImageLoader = new FXMLLoader();
      annotatedImageLoader.setLocation(getClass().getResource("/AnnotatedImage.fxml"));

      /* Define a BorderPane as the base for the entire app */
      BorderPane root = new BorderPane();
      root.setTop(mainMenuLoader.load());
      root.setCenter(annotatedImageLoader.load());

      /* Load controllers */
      mainMenuController = mainMenuLoader.getController();
      mainMenuController.setApp(this);
      annotatedImageController = annotatedImageLoader.getController();

      stage0.setTitle("Photo browser");
      stage0.setMinWidth(500);
      stage0.setMinHeight(500);
      stage0.setScene(new Scene(root, 500, 500));
      stage0.sizeToScene();
      stage0.setMinWidth(300);
      stage0.setMinHeight(500);
      stage0.show();
  }


    @FXML
    public void importPhoto(Image img) {
        System.out.println(img);
        annotatedImageController.setImage(img);
        
    }

}
