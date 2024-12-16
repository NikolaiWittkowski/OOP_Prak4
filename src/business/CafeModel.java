package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import factory.ConcreteCreator;
import factory.Creator;
import factory.Product;
import ownUtil.*;

public class CafeModel implements Observable {
    private ArrayList<Cafe> cafes = new ArrayList<>(); 
    private static CafeModel cafeModel;

    private List<Observer> observers = new ArrayList<Observer>();

    public ArrayList<Cafe> getCafes() {
        return cafes;
    }

    public void addCafe(Cafe cafe) {
        this.cafes.add(cafe);
        notifyObservers(); 
    }

    private CafeModel() {
    }

    public static CafeModel getInstance() {
        if (cafeModel == null) {
            cafeModel = new CafeModel();
        }
        return cafeModel;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update();
        }
    }

    public void leseAusDatei(String typ) throws IOException {
        Creator creator = new ConcreteCreator();
        Product reader = creator.createCr(typ);

        String[] zeile = reader.leseAusDatei();
        this.addCafe(new Cafe(zeile[0], zeile[1], zeile[2], Boolean.parseBoolean(zeile[3]), zeile[4].split(";")));

        reader.schliesseDatei();
        notifyObservers();
    }

    public void schreibeCafesInCsvDatei() throws IOException {
        if (!this.cafes.isEmpty()) {
            try (BufferedWriter aus = new BufferedWriter(new FileWriter("CafeAusgabe.csv", true))) {
                for (Cafe cafe : cafes) {
                    aus.write(cafe.gibCafeZurueck(';'));
                    aus.newLine();
                }
            }
        } else {
            throw new IllegalStateException("Keine Cafes gespeichert.");
        }
    }
}
