import attractions.Attraction;
import attractions.Playground;
import behaviours.IReviewed;
import behaviours.ISecurity;
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

    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor) {
        ArrayList<IReviewed> allAllowed = new ArrayList<>();

        for (IReviewed review : reviewed) {
//          instanceof checking that object is type ISecurity too
            if (review instanceof ISecurity) {
//              casting to ISecurity object to get access to method isAllowedTo()
                if(((ISecurity) review).isAllowedTo(visitor)) {
                    allAllowed.add(review);
                }
            } else {
                allAllowed.add(review);
            }
        }
        return allAllowed;
    }

}
