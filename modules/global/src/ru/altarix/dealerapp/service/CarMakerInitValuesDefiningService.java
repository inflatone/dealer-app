package ru.altarix.dealerapp.service;

import com.haulmont.cuba.security.entity.User;
import ru.altarix.dealerapp.entity.Country;

public interface CarMakerInitValuesDefiningService {
    String NAME = "dealerapp_CarMakerInitValuesDefiningService";

    Country getInitCountry(User user);
}