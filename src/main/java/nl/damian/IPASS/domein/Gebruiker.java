package nl.damian.IPASS.domein;

import java.io.Serializable;
import java.util.ArrayList;

public class Gebruiker implements Serializable {
    private String email;
    private String wachtwoord;
    private Boolean admin;
    private Winkelwagen winkelwagen = new Winkelwagen();
    private static ArrayList<Gebruiker> gebruikers = new ArrayList<>();

    public Gebruiker(String email, String wachtwoord, Boolean admin){
        this.email = email;
        this.wachtwoord = wachtwoord;
        this.admin = admin;

    }

    public static Gebruiker createGebruiker(String email, String wachtwoord, Boolean admin){
        Gebruiker gebruiker = new Gebruiker(email, wachtwoord, admin);

        if(!gebruikers.contains(gebruiker)){
            gebruikers.add(gebruiker);
            return gebruiker;
        }
        return null;
    }

//    public static Gebruiker login(String email, String wachtwoord){
//
//    }

    public Winkelwagen getWinkelwagen() {
        return winkelwagen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public void newProduct(String naam, double prijs){
        if(admin){
            Product p1 = new Product(naam, prijs);
        }
    }

    public void emptyEmails(){
        gebruikers.clear();
    }

    public static ArrayList<Gebruiker> getGebruikers() {
        return gebruikers;
    }

    public static void setGebruikers(ArrayList<Gebruiker> gebruikers) {
        Gebruiker.gebruikers = gebruikers;
    }
}
