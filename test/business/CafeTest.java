package business;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CafeTest {
    
    @Test
    void test2() {
        String[] kaffeeprodukte = { "Tasse Kaffee", "K�nnchen Kaffee" };
        Cafe cafe = new Cafe("Wops", "Duisburg", "B�ckerei", true, kaffeeprodukte);
        
        assertTrue(cafe.getName().equals("Wops") && cafe.getOrt().equals("Duisburg"));
    }
    
    @Test
    void test1() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cafe("Wops", "Duisburg", "B�ckerei", true, null);
        });
    }
}
