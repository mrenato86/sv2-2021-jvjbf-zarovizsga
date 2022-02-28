package shipping;

public class NationalPackage implements Transportable {

    private static final int BASE_COST = 1000;

    private final int weight;
    private final boolean breakable;

    public NationalPackage(int weight, boolean breakable) {
        this.weight = weight;
        this.breakable = breakable;
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
        return breakable ? BASE_COST * 2 : BASE_COST;
    }
}
