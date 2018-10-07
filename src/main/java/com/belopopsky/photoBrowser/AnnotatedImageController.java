package com.belopopsky.photoBrowser;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class AnnotatedImageController {
  @FXML private ImageView annotatedImage;

  @FXML
  void mouseClickHandler(MouseEvent event) {
    System.out.println("CLICK!");
  }
}
