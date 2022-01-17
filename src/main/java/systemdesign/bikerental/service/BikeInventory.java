package systemdesign.bikerental.service;

import systemdesign.bikerental.model.Bike;

import java.util.HashMap;
import java.util.List;

public class BikeInventory implements BikeSearch{
    private HashMap<String, List<Bike>> bikeTypes;
    private HashMap<String, List<Bike>> bikeModels;
    @Override
    public List<Bike> searchByType(String type) {
        //Return all bikes of the given type.
        return bikeTypes.get(type);
    }

    @Override
    public List<Bike> searchByModel(String model) {
        //Return all bikes of the given model.
        return bikeModels.get(model);
    }
}
