package ru.altarix.dealerapp.service;

import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;
import ru.altarix.dealerapp.entity.car.CarBrand;

import javax.inject.Inject;
import java.util.List;

@Service(CarBrandComputingService.NAME)
public class CarBrandComputingServiceBean implements CarBrandComputingService {
    @Inject
    private DataManager dataManager;

    @Override
    public List<CarBrand> findAllNotPaidOrNotSellCarBrands() {
        return dataManager.load(CarBrand.class)
                .query("SELECT DISTINCT c.carBrand FROM dealerapp_Car c " +
                        "      LEFT JOIN dealerapp_Request r ON r.car = c WHERE r IS NULL OR r.paid=false")
                .list();
    }
}