package ru.altarix.dealerapp.service;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.View;
import org.springframework.stereotype.Component;
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

@Component(ContractorNameComputingService.NAME)
public class ContractorNameComputingServiceBean implements ContractorNameComputingService {
    @Inject
    private DataManager dataManager;

    @Override
    public void pasteTransientNames(Collection<? extends Contractor> people) {
        Map<UUID, String> names = retrievePeopleNames();
        people.forEach(p ->
                p.setName(names.getOrDefault(p.getId(), "UNKNOWN")));
    }

    private Map<UUID, String> retrievePeopleNames() {
        Map<UUID, String> result = new HashMap<>();
        retrievePeopleNames(result, Person.class,
                p -> String.format("%s, %s", p.getLastName(), p.getFirstName()));
        retrievePeopleNames(result, Company.class, Company::getTitle);
        return result;
    }

    private <E extends Contractor> void retrievePeopleNames(Map<UUID, String> buffer, Class<E> personClass, Function<E, String> nameExtractor) {
        dataManager.load(personClass)
                .view(View.LOCAL)
                .list()
                .forEach(p -> buffer.put(p.getId(), nameExtractor.apply(p)));
    }
}
