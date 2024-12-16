package guiGastronomien;

import business.Cafe;
import business.CafeModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class GastronomienView {
    private GastronomienControl gastronomienControl;
    private CafeModel cafesModel;

    private Pane pane = new Pane();
    private Label lblAnzeigeCafes = new Label("Anzeige Cafes");
    private TextArea txtAnzeigeCafes = new TextArea();
    private Button btnAnzeigeCafes = new Button("Anzeige");

    public GastronomienView(GastronomienControl gastronomienControl, Stage primaryStage, CafeModel cafesModel) {
        Scene scene = new Scene(this.pane, 560, 340);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Anzeige von Gastronomien");
        primaryStage.show();
        this.gastronomienControl = gastronomienControl;
        this.cafesModel = cafesModel;
        this.initKomponenten();
    }

    private void initKomponenten() {
        Font font = new Font("Arial", 20);
        lblAnzeigeCafes.setLayoutX(310);
        lblAnzeigeCafes.setLayoutY(40);
        lblAnzeigeCafes.setFont(font);
        lblAnzeigeCafes.setStyle("-fx-font-weight: bold;");
        pane.getChildren().add(lblAnzeigeCafes);

        txtAnzeigeCafes.setEditable(false);
        txtAnzeigeCafes.setLayoutX(310);
        txtAnzeigeCafes.setLayoutY(90);
        txtAnzeigeCafes.setPrefWidth(220);
        txtAnzeigeCafes.setPrefHeight(185);
        pane.getChildren().add(txtAnzeigeCafes);

        btnAnzeigeCafes.setLayoutX(310);
        btnAnzeigeCafes.setLayoutY(290);
        pane.getChildren().add(btnAnzeigeCafes);
    }

    public void zeigeCafesAn() {
        if (cafesModel.getCafes() != null && !cafesModel.getCafes().isEmpty()) {
            StringBuilder cafesAnzeige = new StringBuilder();
            for (Cafe cafe : cafesModel.getCafes()) {
                cafesAnzeige.append(cafe.gibCafeZurueck(' ')).append("\n");
            }
            txtAnzeigeCafes.setText(cafesAnzeige.toString());
        } else {
            txtAnzeigeCafes.setText("Keine Cafes verfügbar.");
        }
    }
}

