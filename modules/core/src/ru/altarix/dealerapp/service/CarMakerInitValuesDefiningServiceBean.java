package ru.altarix.dealerapp.service;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.security.entity.User;
import org.springframework.stereotype.Service;
import ru.altarix.dealerapp.config.DefaultValueConfig;
import ru.altarix.dealerapp.entity.Country;
import ru.altarix.dealerapp.entity.user.Manager;

import javax.inject.Inject;

@Service(CarMakerInitValuesDefiningService.NAME)
public class CarMakerInitValuesDefiningServiceBean implements CarMakerInitValuesDefiningService {
    @Inject
    private DataManager dataManager;

    @Inject
    private DefaultValueConfig defaultValueConfig;

    @Override
    public Country getInitCountry(User user) {
        return dataManager.load(Manager.class)
                .viewProperties("country", "country.name")
                .id(user.getId())
                .optional()
                .map(Manager::getCountry)
                .orElse(defaultValueConfig.getDefaultCountry());
    }
}