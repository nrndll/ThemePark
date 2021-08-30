package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    private Visitor visitor;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor = new Visitor(18, 2.1, 70.0);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void visitorIsAllowedOverAgeAndHeight() {
        assertTrue(rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void hasDefaultPrice() {
        assertEquals(8.4, rollerCoaster.defaultPrice(), 0);
    }

    @Test
    public void returnsDoublePriceForTallVisitor() {
        assertEquals(16.8, rollerCoaster.priceFor(visitor), 0);
    }
}
