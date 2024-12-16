package guiGastronomien;

import business.CafeModel;
import guiCafe.CafeView;
import business.CafeModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class GastronomienControl implements Observer {
    private GastronomienView gastronomienView;
    private CafeView caView;
    private CafeModel cafeModel;

    public GastronomienControl(Stage primaryStage) {
        this.cafeModel = CafeModel.getInstance();
        this.gastronomienView = new GastronomienView(this, primaryStage, cafeModel);
        this.cafeModel.addObserver(this);
    }

    @Override
    public void update() {
        this.gastronomienView.zeigeCafesAn();
    }
}
