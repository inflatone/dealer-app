package ru.altarix.dealerapp.service;

import ru.altarix.dealerapp.entity.car.Car;
import ru.altarix.dealerapp.CollectionConsumer;

public interface CarNameComputingService extends CollectionConsumer<Car> {
    String NAME = "dealerapp_CarNameComputingService";
}
