package systemdesign.bikerental.model;

import java.util.List;

public class BikeRentalSystem {
    private String name;
    private List<BikeRentalLocation> locations;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BikeRentalLocation> getLocations() {
        return locations;
    }

    public void setLocations(List<BikeRentalLocation> locations) {
        this.locations = locations;
    }
}
