package com.belopopsky.photoBrowser;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/** Hello world! */
public class App extends Application {
  public static void main(String[] args) {
    Application.launch(args);
  }

  /* App statusbar */
  Label appStatus;
  BorderPane borderPane;
  MenuBar menuBar;
  ToolBar toolbar;

  /* The high level container of all the GUI elements */
  Stage stage;

  /* Entry point */
  @Override
  public void start(Stage stage0) {

    borderPane = new BorderPane();
    menuBar = buildMenuBar();
    toolbar = buildToggleBar();
    appStatus = new Label("Status: what am I?");

    borderPane.setTop(new VBox(menuBar, toolbar));
    borderPane.setBottom(new HBox(appStatus));
    // borderPane.setLeft();
    // borderPane.setRight();
    // borderPane.setCenter();

    stage = stage0;
    stage.setTitle("jPhoto Browser 2018 MASTER DELUXE (jLife package)");
    stage.setMinWidth(500);
    stage.setMinHeight(500);
    stage.setScene(new Scene(borderPane, 500, 500));
    stage.sizeToScene();
    stage.setMinWidth(300);
    stage.setMinHeight(500);
    stage.show();
  }

  /* Builds the toggle bar, with the different photo categories */
  ToolBar buildToggleBar() {
    ToolBar toolbar = new ToolBar();

    ToggleButton familyToggle = new ToggleButton("Family");
    ToggleButton vacationToggle = new ToggleButton("Vacation");
    ToggleButton schoolToggle = new ToggleButton("School");
    ToggleButton screenshotsToggle = new ToggleButton("Screenshots");

    ToggleGroup toggleGroup = new ToggleGroup();

    familyToggle.setToggleGroup(toggleGroup);
    vacationToggle.setToggleGroup(toggleGroup);
    schoolToggle.setToggleGroup(toggleGroup);
    screenshotsToggle.setToggleGroup(toggleGroup);

    toolbar
        .getItems()
        .addAll(
            new Label("Category filter"),
            familyToggle,
            vacationToggle,
            schoolToggle,
            screenshotsToggle);

    return toolbar;
  }

  /* Builds the menu bar */
  MenuBar buildMenuBar() {
    MenuBar menuBar = new MenuBar();
    Menu fileMenu = new Menu("File");

    MenuItem importItem = new MenuItem("Import");
    importItem.setOnAction(
        e -> {
          appStatus.setText("Status: Imports");
        });

    MenuItem deleteItem = new MenuItem("Delete");
    deleteItem.setOnAction(
        e -> {
          appStatus.setText("Status: DELETE! DELETE! DELETE!");
        });

    MenuItem quitItem = new MenuItem("Quit");
    quitItem.setOnAction(
        e -> {
          appStatus.setText("Status: OMG I'M JUST A PHOTO BROWSING APP");
          stage.close();
        });

    fileMenu.getItems().addAll(importItem, deleteItem, quitItem);

    Menu viewMenu = new Menu("View");

    MenuItem photoViewerItem = new MenuItem("Photo viewer");
    photoViewerItem.setOnAction(
        e -> {
          appStatus.setText("Status: I like to view one photo");
        });

    MenuItem browserViewerItem = new MenuItem("Browser viewer");
    browserViewerItem.setOnAction(
        e -> {
          appStatus.setText("Status: I like to view many photos");
        });

    MenuItem splitModeItem = new MenuItem("Split mode");
    splitModeItem.setOnAction(
        e -> {
          appStatus.setText("Status: I like to split modes");
        });

    viewMenu.getItems().addAll(photoViewerItem, browserViewerItem, splitModeItem);

    menuBar.getMenus().addAll(fileMenu, viewMenu);

    return menuBar;
  }
}
