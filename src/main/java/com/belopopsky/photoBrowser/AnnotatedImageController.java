package com.belopopsky.photoBrowser;

import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class AnnotatedImageController {
  @FXML private ImageView annotatedImageHolder;
  @FXML private Canvas annotationArea;

  @FXML
  void mouseClickHandler(MouseEvent event) {
    System.out.println("CLICK!");
    System.out.println(annotationArea);
    System.out.println(annotatedImageHolder);
    File file = new File("bat.jpg");
    Image img = new Image(file.toURI().toString());
    annotatedImageHolder.setImage(img);
  }

  @FXML
  void setImage(Image img) {
    System.out.println(annotationArea);
    System.out.println(annotatedImageHolder);
  }
}
