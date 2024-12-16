package main;

import business.Cafe;
import business.CafeModel;
import guiCafe.CafeControl;
import guiCafe.CafeView;
import guiGastronomien.GastronomienControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new CafeControl(primaryStage);
		
		Stage fenster = new Stage();
		new GastronomienControl(fenster);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
