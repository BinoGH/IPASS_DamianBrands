package nl.damian.IPASS.domein;

import java.io.Serializable;
import java.security.Principal;
import java.util.ArrayList;

public class Gebruiker implements Serializable, Principal {
    private String email;
    private String wachtwoord;
    private Boolean admin;
    private Winkelwagen winkelwagen = new Winkelwagen();
    private static ArrayList<Gebruiker> gebruikers = new ArrayList<>();
    private String role;

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

    public static ArrayList<Gebruiker> getGebruikers() {
        return gebruikers;
    }

    public static void setGebruikers(ArrayList<Gebruiker> gebruikers) {
        Gebruiker.gebruikers = gebruikers;
    }

    public static String validateLogin(String email, String password){
        for(Gebruiker geb : getGebruikers()){
            if(geb.getEmail().equals(email)){
                if(geb.getWachtwoord().equals(password)){
                    if(geb.getAdmin() == true){
                        return "admin";
                    }
                    return "user";
                }
            }
        }
        return null;
    }

    public static Gebruiker getGebruikerByEmail(String email){
        for (Gebruiker geb : getGebruikers()){
            if (geb.getEmail() == email){
                return geb;
            }
        }
        return null;
    }

    public String getRole() {
        if(getAdmin()){
            return "admin";
        }
        return "user";
    }

    @Override
    public String getName() {
        return null;
    }
}
