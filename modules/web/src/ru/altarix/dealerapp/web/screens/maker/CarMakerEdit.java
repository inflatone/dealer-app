package ru.altarix.dealerapp.web.screens.maker;

import com.haulmont.cuba.gui.screen.*;
import ru.altarix.dealerapp.entity.Country;
import ru.altarix.dealerapp.entity.car.CarMaker;
import ru.altarix.dealerapp.service.CarMakerInitValuesDefiningService;
import ru.altarix.dealerapp.web.EntityUtils;

import javax.inject.Inject;

@UiController("dealerapp_CarMaker.edit")
@UiDescriptor("maker-edit.xml")
@EditedEntityContainer("makerDc")
@LoadDataBeforeShow
public class CarMakerEdit extends StandardEditor<CarMaker> {

    @Inject
    private CarMakerInitValuesDefiningService carMakerInitValuesDefiningService;

    @Inject
    private EntityUtils entityUtils;

    @Subscribe
    public void onInitEntity(InitEntityEvent<CarMaker> event) {
        CarMaker entity = event.getEntity();
        Country defaultCountry = carMakerInitValuesDefiningService.getInitCountry(entityUtils.getAuthUser());
        entity.setCountry(defaultCountry);
    }
}
