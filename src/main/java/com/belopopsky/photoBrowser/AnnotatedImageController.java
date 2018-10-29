package com.belopopsky.photoBrowser;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.geometry.Rectangle2D;


public class AnnotatedImageController extends AnchorPane {
  @FXML private ImageView annotatedImageHolder;
  @FXML private Canvas annotatedImageCanvas;
  GraphicsContext graphicsContext;

  @FXML private ScrollPane imagePane;
  @FXML private ScrollPane canvasPane;
  @FXML private AnchorPane photoHolder;
  @FXML private StackPane annotatedImage;

  Text currentText;

  Group textGroup;

  Shape currentShape;

  // ArrayList<AnnotationText> annotationTexts;

  ArrayList<Shape> annotationDrawings;

  boolean isImage = true;

  double mouseX;
  double mouseY;
  double previousMouseX;
  double previousMouseY;

  @FXML
  void initialize() {

    graphicsContext = annotatedImageCanvas.getGraphicsContext2D();
    graphicsContext.setStroke(Color.RED);

    textGroup = new Group(new Text());
    annotatedImage.getChildren().add(textGroup);
    textGroup.toBack();

    annotatedImageCanvas.setFocusTraversable(true);
    annotatedImageCanvas.addEventFilter(MouseEvent.ANY, (e) -> annotatedImageCanvas.requestFocus());
   
    

    annotatedImage.setOnKeyPressed(
        new EventHandler<KeyEvent>() {

          @Override
          public void handle(KeyEvent event) {
            if (currentText != null) {
              System.out.println(event);
              if (event.getCode() == KeyCode.BACK_SPACE) {
                System.out.println("BACKSPACE");
                var prev = currentText.textProperty().getValue();
                if (prev != null && prev.length() > 0) {
                  prev = prev.substring(0, prev.length() - 1);
                }
                currentText.textProperty().setValue(prev);
              } else if (event.getCode() == KeyCode.ENTER) {
                System.out.println("ENTER");
                currentText = null;
              }
            }
          }
        });

    annotatedImageCanvas.setOnKeyTyped(
        new EventHandler<KeyEvent>() {
          @Override
          public void handle(KeyEvent event) {
            if (currentText != null) {
              System.out.println("ADD CHARACTER");
              var prev = currentText.textProperty().getValue();
              currentText.textProperty().setValue(prev + event.getCharacter());
            }
          }
        });

    // annotationTexts = ((Group) getScene().getChildren()).;
  }

  // Double click generate two events, this is used to differentiate between them
  boolean flipped = false;

  @FXML
  void mouseImageClickHandler(MouseEvent event) {
    previousMouseX = mouseX;
    previousMouseY = mouseY;

    mouseX = event.getX();
    mouseY = event.getY();

    var primaryClick = event.getButton().equals(MouseButton.PRIMARY);
    if (primaryClick) {
      if (event.getClickCount() == 2) {
        isImage = false;
        flipped = true;
        canvasPane.toFront();
        textGroup.toFront();
      } else {
        flipped = false;
      }
    }
  }

  @FXML
  void mouseCanvasClickHandler(MouseEvent event) {
    // System.out.println("CLICK!");
    // System.out.println(annotatedImageCanvas);
    // System.out.println(annotatedImageHolder);

    previousMouseX = mouseX;
    previousMouseY = mouseY;

    mouseX = event.getX();
    mouseY = event.getY();

    var primaryClick = event.getButton().equals(MouseButton.PRIMARY);
    if (primaryClick) {
      if (event.getClickCount() == 2) {
        isImage = false;
        imagePane.toFront();
      } else if (event.getClickCount() == 1) {
        System.out.println("Add text");
        if (currentText == null) {
          currentText = new Text();
          currentText.setFill(Color.BLACK);
          currentText.setX(event.getX());
          currentText.setY(event.getY());
          textGroup.getChildren().add(currentText);
        }
        System.out.println(currentText);
        System.out.println(annotatedImage.getChildren());
        System.out.println("text: " + currentText.textProperty().getValue());
      }
    }
  }

  /*
  void drawAnnotations() {
    graphicsContext.clearRect(
        0,
        0,
        annotatedImageHolder.getImage().getWidth(),
        annotatedImageHolder.getImage().getHeight());

    for (var shape : annotationDrawings) {
      graphicsContext.beginPath();
      graphicsContext.moveTo(shape.getPoints().get(0).getX(), shape.getPoints().get(0).getY());
      for (int i = 1; i < shape.getPoints().size(); ++i) {
        graphicsContext.lineTo(shape.getPoints().get(i).getX(), shape.getPoints().get(i).getY());
        graphicsContext.stroke();
      }
      graphicsContext.closePath();
    }

    graphicsContext.setFill(Paint arg0)
    if (currentText != null) {
      graphicsContext.fillText(
          currentText.textProperty().getValue(), currentText.getX(), currentText.getY());
    }
  }
  */

  @FXML
  void startFreeDraw(MouseEvent event) {
    graphicsContext.beginPath();
    // graphicsContext.moveTo(event.getX(), event.getY());
    // graphicsContext.stroke();
  }

  @FXML
  void endFreeDraw(MouseEvent event) {
    graphicsContext.lineTo(event.getX(), event.getY());
    graphicsContext.stroke();
    graphicsContext.closePath();
  }

  @FXML
  void doFreeDraw(MouseEvent event) {
    graphicsContext.lineTo(event.getX(), event.getY());
    graphicsContext.stroke();
    graphicsContext.closePath();
    graphicsContext.beginPath();
    graphicsContext.moveTo(event.getX(), event.getY());
  }

  void setImage(Image img) {

      System.out.println(img);
      annotatedImageHolder.setImage(img);
      System.out.println(annotatedImageHolder.getImage());

    annotatedImageCanvas.widthProperty().bind(annotatedImageHolder.getImage().widthProperty());
    annotatedImageCanvas.heightProperty().bind(annotatedImageHolder.getImage().heightProperty());

    System.out.println(annotatedImageCanvas);
    System.out.println(annotatedImageHolder);
    
  }
}
