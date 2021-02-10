package fr.ventuss.launcher.ui.panel;

import fr.ventuss.launcher.ui.PanelManager;
import javafx.scene.layout.GridPane;

public interface IPanel {

    void init(PanelManager panelManager);
    GridPane getLayout();
    void onShow();
}
