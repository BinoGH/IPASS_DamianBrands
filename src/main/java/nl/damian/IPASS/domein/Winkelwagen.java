package nl.damian.IPASS.domein;

import java.util.ArrayList;

public class Winkelwagen {
    private ArrayList<Product> producten = new ArrayList<Product>();
    private double totalPrice;

    public Winkelwagen(){}

    public void addProduct(Product product){
        producten.add(product);
    }

    public void removeProduct(Product product){
        producten.remove(product);
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < producten.size(); i++){
            totalPrice += producten.get(i).getPrijs();
        }
        return totalPrice;
    }

    public String toString(){
        if(producten.size() < 1){
            return("Uw winkelwagen is leeg!");
        }
        StringBuilder contentString = new StringBuilder();
        for (int i = 0; i < producten.size(); i++){
            contentString.append(producten.get(i).toString());
        }
        return("Winkelwagen:\n" + contentString + "\nTotaalprijs: €" + getTotalPrice());
    }
}
