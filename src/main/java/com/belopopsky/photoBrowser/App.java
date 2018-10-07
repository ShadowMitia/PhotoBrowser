package com.belopopsky.photoBrowser;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/** Hello world! */
public class App extends Application {
  public static void main(String[] args) {
    Application.launch(args);
  }

  @FXML private Label statusBar;

  @FXML private ImageView imageView;

  /* The high level container of all the GUI elements */
  Stage stage;

  /* Entry point */
  @Override
  public void start(Stage stage0) throws Exception {

    Parent root = FXMLLoader.load(getClass().getResource("/PhotoBrowserScene.fxml"));
    /*
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open Resource File");
    File file = fileChooser.showOpenDialog(stage);
    if (file != null) {
      System.out.println(file.toURI().toString());
      System.out.println(imageView);
      Image image = new Image(file.toURI().toString());
      imageView.setImage(image);
    }
    */

    File file = new File("./bat.jpg");
    Image image = new Image(file.toURI().toString());
    imageView.setImage(image);

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
