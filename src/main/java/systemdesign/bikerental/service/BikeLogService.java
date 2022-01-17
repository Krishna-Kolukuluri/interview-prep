package systemdesign.bikerental.service;

import systemdesign.bikerental.model.BikeLogType;

import java.util.List;

public interface BikeLogService {
    public boolean update();
    public List<BikeLogType> searchByLogType(BikeLogType type);
}
