package ru.altarix.dealerapp.web.screens.configuration;

import com.haulmont.cuba.gui.screen.*;
import ru.altarix.dealerapp.entity.car.CarConfiguration;

@UiController("dealerapp_CarConfiguration.edit")
@UiDescriptor("car-configuration-edit.xml")
@EditedEntityContainer("carConfigurationDc")
@LoadDataBeforeShow
public class CarConfigurationEdit extends StandardEditor<CarConfiguration> {
}