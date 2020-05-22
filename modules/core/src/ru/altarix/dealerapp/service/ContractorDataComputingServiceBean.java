package ru.altarix.dealerapp.service;

import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;
import ru.altarix.dealerapp.entity.contractor.Contractor;

import javax.inject.Inject;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service(ContractorDataComputingService.NAME)
public class ContractorDataComputingServiceBean implements ContractorDataComputingService {
    @Inject
    private DataManager dataManager;

    @Override
    public Integer computeRequestAmount(Contractor contractor) {
        return dataManager
                .loadValue("SELECT count(r) FROM dealerapp_Request r WHERE r.contractor =:contractor", Integer.class)
                .parameter("contractor", contractor)
                .optional()
                .orElse(0);
    }

    @Override
    public Map<UUID, Integer> computeRequestAmount(Collection<Contractor> people) {
        return dataManager
                .loadValues("SELECT r.contractor.id, count(r) FROM dealerapp_Request r GROUP BY r.contractor HAVING r.contractor IN (:people)")
                .parameter("people", people)
                .properties("id", "count")
                .list()
                .stream()
                .collect(Collectors.toMap(
                        v -> v.getValue("id"),
                        v -> v.getValue("count")
                ));
    }
}