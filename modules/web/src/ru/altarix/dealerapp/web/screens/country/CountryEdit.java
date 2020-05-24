package ru.altarix.dealerapp.web.screens.country;

import com.haulmont.cuba.gui.screen.*;
import ru.altarix.dealerapp.entity.Country;

@UiController("dealerapp_Country.edit")
@UiDescriptor("country-edit.xml")
@EditedEntityContainer("countryDc")
@LoadDataBeforeShow
public class CountryEdit extends StandardEditor<Country> {
}