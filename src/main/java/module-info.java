module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.materialdesignicons;
    opens fr.ventuss.launcher to javafx.fxml;
    exports fr.ventuss.launcher;
}