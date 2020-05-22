package ru.altarix.dealerapp.service;

import ru.altarix.dealerapp.entity.car.CarBrand;

import java.util.List;

public interface CarBrandComputingService {
    String NAME = "dealerapp_CarBrandComputingService";

    List<CarBrand> findAllNotPaidOrNotSellCarBrands();
}