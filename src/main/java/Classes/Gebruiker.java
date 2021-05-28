package Classes;

import java.util.ArrayList;

public class Gebruiker {
    private String email;
    private String wachtwoord;
    private Boolean admin;
    private Winkelwagen winkelwagen = new Winkelwagen();
    private static ArrayList<String> emails = new ArrayList<>();

    public Gebruiker(String email, String wachtwoord, Boolean admin){
        if(!emails.contains(email)){
            if(admin.equals(false)){
                Winkelwagen winkelwagen = new Winkelwagen();
                emails.add(email);
                this.email = email;
                this.wachtwoord = wachtwoord;
                this.admin = admin;
            }else{
                emails.add(email);
                this.email = email;
                this.wachtwoord = wachtwoord;
                this.admin = admin;
            }
        }
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

    public void emptyEmails(){
        emails.clear();
    }

    public ArrayList<String> getEmails() {
        return emails;
    }
}
