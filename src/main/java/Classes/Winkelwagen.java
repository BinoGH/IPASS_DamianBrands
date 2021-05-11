package Classes;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Winkelwagen {
    private ArrayList<Product> content = new ArrayList<Product>();
    private double totalPrice;

    public Winkelwagen(){}

    public void addProduct(Product product){
        content.add(product);
    }

    public void removeProduct(Product product){
        content.remove(product);
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < content.size(); i++){
            totalPrice += content.get(i).getPrijs();
        }
        return totalPrice;
    }

    public String toString(){
        if(content.size() < 1){
            return("Uw winkelwagen is leeg!");
        }
        StringBuilder contentString = new StringBuilder();
        for (int i = 0; i < content.size(); i++){
            contentString.append(content.get(i).toString());
        }
        return("Winkelwagen:\n" + contentString + "\nTotaalprijs: €" + getTotalPrice());
    }
}
