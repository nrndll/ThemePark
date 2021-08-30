import attractions.Attraction;
import behaviours.IReviewed;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;

public class ThemePark {

    private ArrayList<IReviewed> reviewed;

    public ThemePark() {
        this.reviewed = new ArrayList<>();
    }

    public ArrayList<IReviewed> getAllReviewed() {
        return reviewed;
    }

    public void visit(Visitor visitor, Attraction attraction) {
        attraction.increaseVisitCount();
        visitor.addVisitedAttraction(attraction);
    }
}
