package ru.altarix.dealerapp.service;

import ru.altarix.dealerapp.entity.contractor.Contractor;

import java.util.Collection;

public interface ContractorNameComputingService {
    String NAME = "dealerapp_ContractorNameComputingService";

    void pasteTransientNames(Collection<? extends Contractor> people);
}
