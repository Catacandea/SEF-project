module CarCosCanLivreisan.sef_project {
    requires javafx.controls;
    requires javafx.fxml;

    opens CarCosCanLivreisan.sef_project to javafx.fxml;
    exports CarCosCanLivreisan.sef_project;
}