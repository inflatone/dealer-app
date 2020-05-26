package ru.altarix.dealerapp.service;

import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service(CarMakerBrandCountLoadingService.NAME)
public class CarMakerBrandCountLoadingServiceBean implements CarMakerBrandCountLoadingService {
    @Inject
    private DataManager dataManager;

    @Override
    public Map<UUID, Long> loadCarBrandCountsPerCarMaker(Collection<UUID> makerIds) {
        return dataManager
                .loadValues("select b.carMaker.id, count(b.name) from dealerapp_CarBrand b " +
                        "group by b.carMaker having b.carMaker.id in :makerIds")
                .parameter("makerIds", makerIds)
                .properties("id", "count")
                .list()
                .stream()
                .collect(Collectors.toMap(
                        v -> v.getValue("id"),
                        v -> v.getValue("count"))
                );
    }
}
