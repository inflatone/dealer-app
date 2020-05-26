package ru.altarix.dealerapp.service;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public interface CarMakerBrandCountLoadingService {
    String NAME = "dealerapp_CarMakerBrandCountLoadingService";

    Map<UUID, Long> loadCarBrandCountsPerCarMaker(Collection<UUID> ids);
}
