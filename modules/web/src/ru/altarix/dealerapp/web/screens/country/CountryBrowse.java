package ru.altarix.dealerapp.web.screens.country;

import com.haulmont.cuba.gui.screen.*;
import ru.altarix.dealerapp.entity.Country;

@UiController("dealerapp_Country.browse")
@UiDescriptor("country-browse.xml")
@LookupComponent("countriesTable")
@LoadDataBeforeShow
public class CountryBrowse extends StandardLookup<Country> {
}