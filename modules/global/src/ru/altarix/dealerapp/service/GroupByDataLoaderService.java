package ru.altarix.dealerapp.service;

import java.util.Map;
import java.util.UUID;

public interface GroupByDataLoaderService {
    String NAME = "dealerapp_GroupByDataLoaderService";

    Map<UUID, Long> loadCarBrandCountsPerCarMaker();
}
