import attractions.Attraction;
import attractions.RollerCoaster;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    private ThemePark themePark;
    private Visitor visitor;
    private Attraction attraction;

    @Before
    public void before() {
        themePark = new ThemePark();
        visitor = new Visitor(14, 1.2, 40.0);
        attraction = new RollerCoaster("Blue Ridge", 10);
    }

    @Test
    public void canVisit() {
        themePark.visit(visitor, attraction);
        assertEquals(1, attraction.getVisitCount());
        assertEquals(1, visitor.getNumVisitedAttractions());
    }

}
