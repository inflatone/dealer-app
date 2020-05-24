package ru.altarix.dealerapp.service;

import ru.altarix.dealerapp.entity.car.CarMaker;

import java.util.Collection;

public interface CarMakerTransientValuesComputingService {
    String NAME = "dealerapp_CarMakerTransientValuesComputingService";

    void pasteCarBrandCounts(Collection<? extends CarMaker> makers);
}
