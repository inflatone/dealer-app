package ru.altarix.dealerapp.service;

import com.haulmont.cuba.core.entity.BaseUuidEntity;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.View;
import org.springframework.stereotype.Service;
import ru.altarix.dealerapp.entity.contractor.Company;
import ru.altarix.dealerapp.entity.contractor.Contractor;
import ru.altarix.dealerapp.entity.contractor.Person;

import javax.inject.Inject;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

@Service(ContractorNameLoadingService.NAME)
public class ContractorNameLoadingServiceBean implements ContractorNameLoadingService {
    @Inject
    private DataManager dataManager;

    @Inject
    private Metadata metadata;

    @Override
    public Map<UUID, String> loadContractorNames(Collection<UUID> contractorIds) {
        Map<UUID, String> result = new HashMap<>();
        Map<UUID, String> personNames = retrievePeopleNames(contractorIds, Person.class,
                p -> String.format("%s, %s", p.getLastName(), p.getFirstName()));
        Map<UUID, String> companyNames = retrievePeopleNames(contractorIds, Company.class, Company::getTitle);
        result.putAll(personNames);
        result.putAll(companyNames);
        return result;
    }

    private <E extends Contractor> Map<UUID, String> retrievePeopleNames(Collection<UUID> ids, Class<E> personClass, Function<E, String> nameExtractor) {
        String cubaClassName = requireNonNull(metadata.getClass(personClass), personClass + ": wrong class").getName();
        return dataManager.load(personClass)
                .query("select c from " + cubaClassName + " c where c.id in :ids")
                .parameter("ids", ids)
                .view(View.LOCAL)
                .list()
                .stream()
                .collect(Collectors.toMap(
                        BaseUuidEntity::getUuid,
                        nameExtractor::apply
                ));
    }
}