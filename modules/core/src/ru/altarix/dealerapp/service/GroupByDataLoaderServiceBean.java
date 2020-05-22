package ru.altarix.dealerapp.service;

import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service(GroupByDataLoaderService.NAME)
public class GroupByDataLoaderServiceBean implements GroupByDataLoaderService {
    @Inject
    private DataManager dataManager;

    @Override
    public Map<UUID, Long> loadCarBrandCountsPerCarMaker() {
        return dataManager
                .loadValues("SELECT b.carMaker.id, count(b.name) FROM dealerapp_CarBrand b GROUP BY b.carMaker")
                .properties("id", "count")
                .list()
                .stream()
                .collect(Collectors.toMap(
                        v -> v.getValue("id"),
                        v -> v.getValue("count"))
                );
    }
}
