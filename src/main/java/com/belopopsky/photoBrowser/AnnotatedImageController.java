package com.belopopsky.photoBrowser;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class AnnotatedImageController {
  @FXML private ImageView annotatedImageHolder;
  @FXML private Canvas annotatedImageCanvas;
  @FXML private ScrollPane imagePane;
  @FXML private ScrollPane canvasPane;

  boolean isImage = true;

  @FXML
  void initialize() {
    // annotatedImageCanvas =
    //     new Canvas(annotatedImageHolder.getFitWidth(), annotatedImageHolder.getFitHeight());
  }

  @FXML
  void mouseClickHandler(MouseEvent event) {
    System.out.println("CLICK!");
    System.out.println(annotatedImageCanvas);
    System.out.println(annotatedImageHolder);
    // File file = new File("bat.jpg");
    // Image img = new Image(file.toURI().toString());
    // annotatedImageHolder.setImage(img);

    var doubleClick = event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2;

    if (isImage && doubleClick) {
      System.out.println("DOUBLE CLICK");
      System.out.println("To canvas");
      isImage = !isImage;
      canvasPane.toFront();
    } else if (!isImage && doubleClick) {
      System.out.println("DOUBLE CLICK");
      System.out.println("To image");
      isImage = !isImage;
      imagePane.toFront();
    }
  }

  void setImage(Image img) {
    System.out.println(annotatedImageCanvas);
    System.out.println(annotatedImageHolder);
  }
}
