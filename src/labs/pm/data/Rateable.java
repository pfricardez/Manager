package labs.pm.data;

@FunctionalInterface
public interface Rateable<T> {
    
    public static final Rating DEFAUL_RATING = Rating.NOT_RATED;

    T applyRating(Rating rating);

    public static Rating convert(int stars) {
        return (stars >= 0 && stars <=5) ? Rating.values()[stars]: DEFAUL_RATING;
    }

    public default T applyRating(int stars) {
        return applyRating(convert(stars));
    }

    public default Rating getRating() {
        return DEFAUL_RATING;
    }

}
