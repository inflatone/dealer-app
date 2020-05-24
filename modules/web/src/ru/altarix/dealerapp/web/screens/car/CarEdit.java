package ru.altarix.dealerapp.web.screens.car;

import com.haulmont.cuba.gui.components.Field;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.components.ValidationException;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.InstanceLoader;
import com.haulmont.cuba.gui.screen.*;
import ru.altarix.dealerapp.entity.car.Car;
import ru.altarix.dealerapp.entity.car.CarBrand;
import ru.altarix.dealerapp.entity.car.CarConfiguration;
import ru.altarix.dealerapp.entity.car.CarMaker;

import javax.inject.Inject;
import java.time.LocalDate;

@UiController("dealerapp_Car.edit")
@UiDescriptor("car-edit.xml")
@EditedEntityContainer("carDc")
public class CarEdit extends StandardEditor<Car> {
    @Inject
    private InstanceLoader<Car> carDl;

    @Inject
    private CollectionLoader<CarMaker> makerDl;

    @Inject
    private CollectionLoader<CarBrand> carBrandsDl;

    @Inject
    private CollectionLoader<CarConfiguration> carConfigurationsDl;

    @Inject
    private LookupPickerField<CarMaker> makerField;

    @Inject
    private LookupPickerField<CarBrand> carBrandField;

    @Inject
    private LookupPickerField<CarConfiguration> carConfigurationField;

    @Inject
    private Field<Integer> priceField;

    @Subscribe
    protected void onInit(InitEvent event) {
        makerDl.load();
        priceField.addValidator(v -> {
            CarConfiguration carConfig = carConfigurationField.getValue();
            if (carConfig != null && carConfig.getPrice().compareTo(v) > 0) {
                throw new ValidationException("must be greater than " + carConfig.getPrice());
            }
        });
    }

    @Subscribe
    public void onInitEntity(InitEntityEvent<Car> event) {
        disableCarBrandField();
        event.getEntity().setYear(LocalDate.now().getYear());
    }

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        carDl.load();
    }


    @Subscribe("makerField")
    public void onMakerFieldValueChange(HasValue.ValueChangeEvent<CarMaker> event) {
        if (makerField.isEmpty()) {
            disableCarBrandField();
        } else {
            carBrandsDl.setParameter("maker", makerField.getValue());
            carBrandsDl.load();
            carBrandField.setEditable(true);
        }
    }

    @Subscribe("carBrandField")
    public void onCarBrandFieldValueChange(HasValue.ValueChangeEvent<CarBrand> event) {
        if (carBrandField.isEmpty()) {
            disableCarConfigurationField();
        } else {
            carConfigurationsDl.setParameter("brand", carBrandField.getValue());
            carConfigurationsDl.load();
            carConfigurationField.setEditable(true);
        }
    }

    @Subscribe("carConfigurationField")
    public void onCarConfigurationFieldValueChange(HasValue.ValueChangeEvent<CarConfiguration> event) {
        if (carConfigurationField.isEmpty()) {
            disablePriceField();
        } else {
            CarConfiguration carConfig = carConfigurationField.getValue();
            priceField.setValue(carConfig.getPrice());
            priceField.setEditable(true);
        }
    }

    private void disableCarBrandField() {
        disableCarConfigurationField();
        carBrandField.setEditable(false);
        carBrandField.clear();
    }

    private void disableCarConfigurationField() {
        disablePriceField();
        carConfigurationField.setEditable(false);
        carConfigurationField.clear();
    }

    private void disablePriceField() {
        priceField.setEditable(false);
        priceField.clear();
    }
}