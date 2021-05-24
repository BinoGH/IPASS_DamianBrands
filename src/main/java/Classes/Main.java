package Classes;

public class Main {
    public static void main(String args[]){
        Gebruiker g1 = new Gebruiker("gamer@nl", "pog", false);

        Product p1 = new Product("product1", 2.50);
        Product p2 = new Product("product2", 1.50);
        Product p3 = new Product("product3", 2.30);

        g1.getWinkelwagen().addProduct(p1);

        System.out.println(g1.getWinkelwagen().toString());

//
//        Winkelwagen w1 = new Winkelwagen();
//        w1.addProduct(p1);
//        w1.addProduct(p2);
//        w1.addProduct(p3);
//
//        System.out.println(p1);
//        System.out.println(p2);
//        System.out.println(w1);
    }
}
