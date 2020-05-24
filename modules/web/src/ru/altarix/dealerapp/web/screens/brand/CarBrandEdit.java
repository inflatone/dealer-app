package ru.altarix.dealerapp.web.screens.brand;

import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import ru.altarix.dealerapp.entity.car.CarBrand;
import ru.altarix.dealerapp.entity.car.CarConfiguration;

import javax.inject.Inject;

@UiController("dealerapp_CarBrand.edit")
@UiDescriptor("car-brand-edit.xml")
@EditedEntityContainer("carBrandDc")
public class CarBrandEdit extends StandardEditor<CarBrand> {
    @Inject
    private CollectionLoader<CarConfiguration> carConfigurationsDl;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        carConfigurationsDl.setParameter("brand", getEditedEntity());
        getScreenData().loadAll();
    }
}