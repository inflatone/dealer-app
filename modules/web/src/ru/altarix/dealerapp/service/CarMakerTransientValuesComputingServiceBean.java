package ru.altarix.dealerapp.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.altarix.dealerapp.entity.car.CarMaker;

import javax.inject.Inject;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

@Component(CarMakerTransientValuesComputingService.NAME)
public class CarMakerTransientValuesComputingServiceBean implements CarMakerTransientValuesComputingService {
    @Inject
    private GroupByDataLoaderService groupByDataLoaderService;

    @Override
    public void pasteCarBrandCounts(Collection<? extends CarMaker> makers) {
        Map<UUID, Long> counts = groupByDataLoaderService.loadCarBrandCountsPerCarMaker();
        makers.forEach(m -> m.setBrandCount(counts.getOrDefault(m.getUuid(), 0L)));
    }
}
