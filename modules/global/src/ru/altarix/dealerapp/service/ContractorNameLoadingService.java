package ru.altarix.dealerapp.service;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public interface ContractorNameLoadingService {
    String NAME = "dealerapp_ContractorNameLoadingService";

    Map<UUID, String> loadContractorNames(Collection<UUID> contractorIds);
}