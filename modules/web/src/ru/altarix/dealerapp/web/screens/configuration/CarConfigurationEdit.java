package ru.altarix.dealerapp.web.screens.configuration;

import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.screen.*;
import ru.altarix.dealerapp.entity.car.CarBrand;
import ru.altarix.dealerapp.entity.car.CarConfiguration;

import javax.inject.Inject;

@UiController("dealerapp_CarConfiguration.edit")
@UiDescriptor("car-configuration-edit.xml")
@EditedEntityContainer("carConfigurationDc")
@LoadDataBeforeShow
public class CarConfigurationEdit extends StandardEditor<CarConfiguration> {
    private CarBrand actualCarBrand;

    public CarBrand getActualCarBrand() {
        return actualCarBrand;
    }

    public void setActualCarBrand(CarBrand actualCarBrand) {
        this.actualCarBrand = actualCarBrand;
    }

    @Inject
    private LookupPickerField<CarBrand> carBrandField;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        setCarBrand();
    }

    @Subscribe("carBrandField")
    public void onCarBrandFieldValueChange(HasValue.ValueChangeEvent<CarBrand> event) {
        carBrandField.setEnabled(false);
    }

    private void setCarBrand() {
        if (actualCarBrand != null) {
            carBrandField.setValue(actualCarBrand);
        }
    }
}