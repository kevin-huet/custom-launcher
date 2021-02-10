package fr.ventuss.launcher;

import fr.ventuss.launcher.ui.PanelManager;
import javafx.stage.Stage;

public class Launcher {

    private PanelManager panelManager;

    public void init(Stage stage) {
        this.panelManager = new PanelManager(this, stage);
        this.panelManager.init();
    }
}
