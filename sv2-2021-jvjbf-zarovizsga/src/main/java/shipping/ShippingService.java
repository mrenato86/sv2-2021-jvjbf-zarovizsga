package shipping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShippingService {

    private final List<Transportable> packages = new ArrayList<>();

    public void addPackage(Transportable pack) {
        if (pack != null) {
            packages.add(pack);
        }
    }

    public List<Transportable> getPackages() {
        return List.copyOf(packages);
    }

    public List<Transportable> collectItemsByBreakableAndWeight(boolean breakable, int weight) {
        return packages.stream()
                .filter(p -> p.isBreakable() == breakable)
                .filter(p -> p.getWeight() >= weight)
                .collect(Collectors.toList());
    }

    public Map<String, Integer> collectTransportableByCountry() {
        return packages.stream()
                .collect(Collectors.groupingBy(Transportable::getDestinationCountry,
                        Collectors.summingInt(p -> 1))); //counting() szebb lenne, de Integer kell specifikáció szerint
    }

    public List<Transportable> sortInternationalPackagesByDistance() {
        return packages.stream()
                .filter(p -> p instanceof InternationalPackage)
                .map(p -> (InternationalPackage) p)
                .sorted(Comparator.comparingInt(InternationalPackage::getDistance))
                .collect(Collectors.toList());
    }
}
