package nl.damian.IPASS.persistence;

import nl.damian.IPASS.domein.Gebruiker;
import nl.damian.IPASS.domein.Product;

import java.io.Serializable;
import java.util.ArrayList;

public class CollectiveClass implements Serializable {
    private ArrayList<Product> assortiment = new ArrayList<>();
    private ArrayList<Gebruiker> gebruikers = new ArrayList<>();

    public ArrayList<Product> getAssortiment() {
        return assortiment;
    }

    public void setAssortiment(ArrayList<Product> assortiment) {
        this.assortiment = assortiment;
    }

    public ArrayList<Gebruiker> getGebruikers() {
        return gebruikers;
    }

    public void setGebruikers(ArrayList<Gebruiker> gebruikers) {
        this.gebruikers = gebruikers;
    }
}
