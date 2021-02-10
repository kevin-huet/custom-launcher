package fr.ventuss.launcher.ui.panel.inside;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import fr.ventuss.launcher.ui.PanelManager;
import fr.ventuss.launcher.ui.panel.Panel;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class PanelTop extends Panel {

    private GridPane bar;

    @Override
    public void init(PanelManager manager) {
        super.init(manager);
        GridPane barButton = new GridPane();
        Label title = new Label();
        MaterialDesignIconView fullscreen = new MaterialDesignIconView(MaterialDesignIcon.WINDOW_MAXIMIZE);
        MaterialDesignIconView close = new MaterialDesignIconView(MaterialDesignIcon.CLOSE);
        MaterialDesignIconView reduce = new MaterialDesignIconView(MaterialDesignIcon.WINDOW_MINIMIZE);

        this.initBar(barButton, title);
        this.initCloseButton(close);
        this.initReduceButton(reduce);
        this.initFullscreenButton(fullscreen);
        bar.getChildren().addAll(close, fullscreen, reduce);
    }

    private void initBar(GridPane barButton, Label title) {
        this.layout.getChildren().add(barButton);
        GridPane.setHgrow(barButton, Priority.ALWAYS);
        GridPane.setVgrow(barButton, Priority.ALWAYS);
        this.bar = this.layout;
        this.layout.setStyle("-fx-background-color: rgb(31, 35, 37);");
        this.layout.getChildren().add(title);
        title.setFont(Font.font("Consolas", FontWeight.THIN, FontPosture.REGULAR, 22.0f));
        title.setStyle("-fx-text-fill: white;");
        GridPane.setHalignment(title, HPos.CENTER);
        barButton.setMinWidth(100.0d);
        barButton.setMaxWidth(100.0d);
        GridPane.setHgrow(barButton, Priority.ALWAYS);
        GridPane.setVgrow(barButton, Priority.ALWAYS);
        GridPane.setHalignment(bar, HPos.RIGHT);

    }

    private void initFullscreenButton(MaterialDesignIconView fullscreen) {
        fullscreen.setFill(Color.WHITE);
        fullscreen.setSize("18.0px");
        fullscreen.setOnMouseEntered(e -> fullscreen.setOpacity(1.0f));
        fullscreen.setOnMouseExited(e -> fullscreen.setOpacity(0.70f));
        fullscreen.setOnMouseClicked(e -> this.panelManager.getStage().setMaximized(!this.panelManager.getStage().isMaximized()));
        fullscreen.setOpacity(0.70f);
        fullscreen.setTranslateX(50.0d);
    }

    private void initCloseButton(MaterialDesignIconView close) {
        close.setFill(Color.WHITE);
        close.setSize("18.0px");
        close.setOnMouseEntered(e -> close.setOpacity(1.0f));
        close.setOnMouseExited(e -> close.setOpacity(0.70f));
        close.setOnMouseClicked(e -> System.exit(0));
        close.setOpacity(0.70f);
        close.setTranslateX(70.0d);
    }

    private void initReduceButton(MaterialDesignIconView reduce) {
        reduce.setFill(Color.WHITE);
        reduce.setSize("18.0px");
        reduce.setOnMouseEntered(e -> reduce.setOpacity(1.0f));
        reduce.setOnMouseExited(e -> reduce.setOpacity(0.70f));
        reduce.setOnMouseClicked(e -> this.panelManager.getStage().hide());
        reduce.setOpacity(0.70f);
        reduce.setTranslateX(30.0d);
    }
}
