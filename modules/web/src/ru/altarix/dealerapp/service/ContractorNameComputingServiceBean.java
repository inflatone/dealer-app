package ru.altarix.dealerapp.service;

import org.springframework.stereotype.Component;
import ru.altarix.dealerapp.entity.contractor.Contractor;
import ru.altarix.dealerapp.web.Utils;

import javax.inject.Inject;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

@Component(ContractorNameComputingService.NAME)
public class ContractorNameComputingServiceBean implements ContractorNameComputingService {
    @Inject
    private ContractorNameLoadingService contractorNameLoadingService;

    @Inject
    private Utils utils;

    @Override
    public void pasteTransientNames(Collection<? extends Contractor> people) {
        Map<UUID, String> names = contractorNameLoadingService.loadContractorNames(utils.retrieveUuids(people));
        people.forEach(p ->
                p.setName(names.getOrDefault(p.getId(), "UNKNOWN")));
    }
}
