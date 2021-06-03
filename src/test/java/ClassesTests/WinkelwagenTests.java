package ClassesTests;

import nl.damian.IPASS.Classes.Product;
import nl.damian.IPASS.Classes.Winkelwagen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WinkelwagenTests {
    private Winkelwagen winkelwagen;
    private Product product1;
    private Product product2;

    @BeforeEach
    public void init(){
        product1 = new Product("Product 1", 1.50);
        product2 = new Product("Product 2", 2.25);
        winkelwagen = new Winkelwagen();
    }

    @Test
    public void emptyWinkelwagen(){
        assertEquals("Uw winkelwagen is leeg!", winkelwagen.toString());
    }

    @Test
    public void prijsEenProduct(){
        winkelwagen.addProduct(product1);
        assertEquals(1.50, winkelwagen.getTotalPrice());
    }

    @Test
    public void prijsTweeProducten(){
        winkelwagen.addProduct(product1);
        winkelwagen.addProduct(product2);
        assertEquals(3.75, winkelwagen.getTotalPrice());
    }
}
