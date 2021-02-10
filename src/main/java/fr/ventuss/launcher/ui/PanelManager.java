package fr.ventuss.launcher.ui;

import fr.ventuss.launcher.Launcher;
import fr.ventuss.launcher.ui.panel.IPanel;
import fr.ventuss.launcher.ui.panel.inside.PanelTop;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PanelManager {

    private final Launcher launcher;
    private final Stage stage;
    private GridPane layout;
    private PanelTop panelTop = new PanelTop();
    private GridPane panelCenter = new GridPane();

    public PanelManager(Launcher launcher, Stage stage) {
        this.launcher = launcher;
        this.stage = stage;
    }

    public void init() {
        RowConstraints panelTopConstraints = new RowConstraints();
        initStage();
        this.layout = new GridPane();
        this.layout.setStyle("-fx-background-color : #ffaadd;");
        this.stage.setScene(new Scene(this.layout));

        panelTopConstraints.setValignment(VPos.TOP);
        panelTopConstraints.setMinHeight(25);
        panelTopConstraints.setMaxHeight(25);
        this.layout.getRowConstraints().addAll(panelTopConstraints, new RowConstraints());
        this.layout.add(this.panelTop.getLayout(), 0, 0);
        this.panelTop.init(this);

        this.layout.add(this.panelCenter, 0, 1);
        GridPane.setVgrow(this.panelCenter, Priority.ALWAYS);
        GridPane.setHgrow(this.panelCenter, Priority.ALWAYS);
    }

    private void initStage() {
        this.stage.setTitle("Launcher");
        this.stage.setMinWidth(1280);
        this.stage.setWidth(1280);
        this.stage.setMinHeight(720);
        this.stage.setHeight(720);
        this.stage.initStyle(StageStyle.UNDECORATED);
        this.stage.centerOnScreen();
        this.stage.show();
    }

    public void ShowPanel(IPanel panel) {
        this.panelCenter.getChildren().clear();
        this.panelCenter.getChildren().add(panel.getLayout());
        panel.init(this);
        panel.onShow();
    }

    public Launcher getLauncher() {
        return launcher;
    }

    public Stage getStage() {
        return stage;
    }

    public GridPane getLayout() {
        return layout;
    }

    public void setLayout(GridPane layout) {
        this.layout = layout;
    }

    public PanelTop getPanelTop() {
        return panelTop;
    }

    public void setPanelTop(PanelTop panelTop) {
        this.panelTop = panelTop;
    }
}
