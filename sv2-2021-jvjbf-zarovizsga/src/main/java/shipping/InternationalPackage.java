package shipping;

public class InternationalPackage implements Transportable {

    private static final int BASE_COST = 1200;
    private static final int KM_FEE = 10;

    private final int weight;
    private final boolean breakable;
    private final String destinationCountry;
    private final int distanceInKm;

    public InternationalPackage(int weight, boolean breakable, String destinationCountry, int distanceInKm) {
        this.weight = weight;
        this.breakable = breakable;
        this.destinationCountry = destinationCountry;
        this.distanceInKm = distanceInKm;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }

    @Override
    public int calculateShippingPrice() {
        int cost = breakable ? BASE_COST * 2 : BASE_COST;
        return cost + KM_FEE * distanceInKm;
    }

    @Override
    public String getDestinationCountry() {
        return destinationCountry;
    }

    public int getDistance() {
        return distanceInKm;
    }
}
