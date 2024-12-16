package guiCafe;

import java.util.ArrayList;

import business.Cafe;
import ownUtil.*;
import business.CafeModel;
import javafx.stage.Stage;

public class CafeControl implements Observer {
    private CafeView caView;
    private CafeModel caMod;

    public CafeControl(Stage primaryStage) {
        this.caMod = CafeModel.getInstance();
        this.caView = new CafeView(this, primaryStage, caMod);
        this.caMod.addObserver(this);
    }

    public void nehmeCafeAuf() {
        try {
            Cafe cafe = new Cafe(
                caView.getTxtName(),
                caView.getTxtOrt(),
                caView.getTxtBeschreibung(),
                Boolean.parseBoolean(caView.getTxtMitBackwerk()),
                caView.getTxtKaffeeprodukte().split(";")
            );
            
            caMod.addCafe(cafe);  
            caView.zeigeCafeAn(); 
        } catch (Exception e) {
            caView.zeigeFehlermeldungsfensterAn("Fehler: " + e.getMessage());
        }
    }

    public void zeigeCafeAn() {
        ArrayList<Cafe> cafes = caMod.getCafes();
        if (cafes != null && !cafes.isEmpty()) {
            StringBuilder cafeAnzeige = new StringBuilder();
            for (Cafe cafe : cafes) {
                cafeAnzeige.append(cafe.gibCafeZurueck(';')).append("\n");
            }
            caView.setTxtAnzeige(cafeAnzeige.toString()); 
        } else {
            caView.setTxtAnzeige("Keine Cafes verfügbar.");
        }
    }

    public void importiereCafe(String typ) {
        try {
            caMod.leseAusDatei(typ);
            caView.zeigeCafeAn(); 
            caView.zeigeInformationsfensterAn("Daten erfolgreich importiert.");
        } catch (Exception e) {
            caView.zeigeFehlermeldungsfensterAn("Fehler: " + e.getMessage());
        }
    }

    public void exportiereCafe() {
        try {
            if (caMod.getCafes() != null && !caMod.getCafes().isEmpty()) {
                caMod.schreibeCafesInCsvDatei(); 
                caView.zeigeInformationsfensterAn("Daten erfolgreich exportiert.");
            } else {
                caView.zeigeFehlermeldungsfensterAn("Keine Cafes zum Exportieren vorhanden.");
            }
        } catch (Exception e) {
            caView.zeigeFehlermeldungsfensterAn("Fehler: " + e.getMessage());
        }
    }

    @Override
    public void update() {
       
        this.caView.zeigeCafeAn();
    }
}

