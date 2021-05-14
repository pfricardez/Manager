package labs.pm.data;

import java.io.Serializable;

public class Review implements Comparable<Review>, Serializable {

    private Rating rating;
    private String comments;

    public Review(Rating rating, String comments) {
        this.rating = rating;
        this.comments = comments;
    }

    public Rating getRating() {
        return rating;
    }

    public String getComments() {
        return comments;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        return sb.append("rating = ").append(rating).append(", comments = ").append(comments).toString();
    }

    @Override
    public int compareTo(Review other) {
        return other.rating.ordinal() - this.rating.ordinal();
    }
}
