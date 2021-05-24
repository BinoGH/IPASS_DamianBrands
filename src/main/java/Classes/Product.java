package Classes;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Product {
    private String name;
    private double prijs;
    private String beschrijving;
    private static ArrayList<Product> assortiment = new ArrayList<Product>();

    public Product(String name, double prijs){
        this.name = name;
        this.prijs = prijs;
        assortiment.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public static ArrayList<Product> getAssortiment() {
        return assortiment;
    }

    public String toString(){
        return("Naam: " + name + "\nPrijs: €" + prijs + "\n");
    }
}
