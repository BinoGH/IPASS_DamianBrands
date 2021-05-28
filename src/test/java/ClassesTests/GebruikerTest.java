package ClassesTests;

import Classes.Gebruiker;
import Classes.Product;
import Classes.Winkelwagen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GebruikerTest {
    private Gebruiker gebruiker1;
    private Gebruiker gebruiker2;
    private Gebruiker gebruiker3;
    private Product p1;
    private Product p2;

    @BeforeEach
    public void init(){
        gebruiker1 = new Gebruiker("email1", "w8woord", false);
        gebruiker2 = new Gebruiker("email2", "123", true);
    }

    @AfterEach
    public void cleanUp(){
        gebruiker1.emptyEmails();
    }

    @Test
    public void nietAdminMaakProduct(){
        gebruiker1.newProduct("productTest", 1.00);
        assertEquals(0, Product.getAssortiment().toArray().length);
    }

    @Test
    public void adminMaakProduct(){
        System.out.println(gebruiker2.getAdmin());
        System.out.println(gebruiker2.toString());
        gebruiker2.newProduct("productTest", 1.00);
        assertEquals(1, Product.getAssortiment().toArray().length);
    }

    @Test
    public void zelfdeEmails(){
        gebruiker3 = new Gebruiker("email1", "w8woord", false);
        assertEquals(2, gebruiker3.getEmails().toArray().length);
    }
}
