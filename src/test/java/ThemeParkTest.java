import attractions.Attraction;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import java.util.ArrayList;
import java.util.HashMap;

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

    @Test
    public void canGetAllReviews() {
        themePark.addReview(attraction);
        HashMap<String, Integer> reviews = themePark.allReviews();
        int rating = reviews.get("Blue Ridge");
        assertEquals(10, rating);
    }

//    @Test
//    public void canGetAllAllowed() {
//        ArrayList<IReviewed> allAllowed = themePark.getAllAllowed(visitor);
//        assertEquals(0, allAllowed.size());
//    }
}
