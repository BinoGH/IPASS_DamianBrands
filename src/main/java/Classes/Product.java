package Classes;

public class Product {
    private String name;
    private double prijs;
    private String beschrijving;

    public Product(String name, double prijs){
        this.name = name;
        this.prijs = prijs;
    }

//    public Product(String name, double prijs, String beschrijving){
//        name = this.name;
//        prijs = this.prijs;
//        beschrijving = this.beschrijving;
//    }

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

    public String toString(){
        return("Naam: " + name + "\nPrijs: €" + prijs + "\n");
    }
}
