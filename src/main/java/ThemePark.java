import attractions.Attraction;
import behaviours.IReviewed;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    private ArrayList<IReviewed> reviewed;

    public ThemePark() {
        this.reviewed = new ArrayList<>();
    }

    public ArrayList<IReviewed> getAllReviewed() {
        return reviewed;
    }

    public void addReview(IReviewed review) {
        reviewed.add(review);
    }

    public void visit(Visitor visitor, Attraction attraction) {
        attraction.increaseVisitCount();
        visitor.addVisitedAttraction(attraction);
    }

    public HashMap<String, Integer> allReviews() {
        HashMap<String, Integer> allReviews = new HashMap<>();
        for (IReviewed review : reviewed) {
            allReviews.put(review.getName(), review.getRating());
        }
        return  allReviews;
    }
}
