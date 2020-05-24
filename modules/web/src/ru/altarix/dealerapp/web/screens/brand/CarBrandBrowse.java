package ru.altarix.dealerapp.web.screens.brand;

import com.haulmont.cuba.gui.screen.*;
import ru.altarix.dealerapp.entity.car.CarBrand;

@UiController("dealerapp_CarBrand.browse")
@UiDescriptor("car-brand-browse.xml")
@LookupComponent("carBrandsTable")
@LoadDataBeforeShow
public class CarBrandBrowse extends StandardLookup<CarBrand> {
}