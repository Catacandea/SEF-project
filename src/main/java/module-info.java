module CarCosCanLivreisan.sef_project {
    requires javafx.controls;
    requires javafx.fxml;
	requires com.fasterxml.jackson.databind;
	requires com.fasterxml.jackson.core;
	requires javafx.graphics;

    opens CarCosCanLivreisan.sef_project to javafx.fxml;
    exports CarCosCanLivreisan.sef_project;
}