package ru.altarix.dealerapp.service;

import com.haulmont.cuba.core.global.MetadataTools;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.altarix.dealerapp.entity.car.Car;

import javax.inject.Inject;

@Component
public class CarNameComputingServiceBean implements CarNameComputingService {
    public static final String CAR_NAME_FORMAT = "%s — %s — %s";

    @Inject
    private MetadataTools metadataTools;

    @Override
    public void accept(Car car) {
        String name = String.format(CAR_NAME_FORMAT,
                metadataTools.getInstanceName(car.getCarMaker()),
                metadataTools.getInstanceName(car.getCarBrand()),
                metadataTools.getInstanceName(car.getCarConfiguration()));
        car.setName(name);
    }
}
