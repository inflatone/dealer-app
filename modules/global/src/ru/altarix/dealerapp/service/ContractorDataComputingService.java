package ru.altarix.dealerapp.service;

import ru.altarix.dealerapp.entity.contractor.Contractor;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public interface ContractorDataComputingService {
    String NAME = "dealerapp_ContractorDataComputingService";

    Integer computeRequestAmount(Contractor contractor);

    Map<UUID, Integer> computeRequestAmount(Collection<Contractor>people);
}