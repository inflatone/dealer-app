package ru.altarix.dealerapp.service;

import org.springframework.stereotype.Component;
import ru.altarix.dealerapp.entity.car.CarMaker;
import ru.altarix.dealerapp.web.Utils;

import javax.inject.Inject;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

@Component(CarMakerTransientValuesComputingService.NAME)
public class CarMakerTransientValuesComputingServiceBean implements CarMakerTransientValuesComputingService {
    @Inject
    private CarMakerBrandCountLoadingService carMakerBrandCountLoadingService;

    @Inject
    private Utils utils;

    @Override
    public void pasteCarBrandCounts(Collection<? extends CarMaker> makers) {
        Map<UUID, Long> counts = carMakerBrandCountLoadingService.loadCarBrandCountsPerCarMaker(utils.retrieveUuids(makers));
        makers.forEach(m -> m.setBrandCount(counts.getOrDefault(m.getUuid(), 0L)));
    }
}
