package ru.altarix.dealerapp.web.screens.color;

import com.haulmont.cuba.gui.screen.*;
import ru.altarix.dealerapp.entity.car.CarColor;

@UiController("dealerapp_Color.edit")
@UiDescriptor("color-edit.xml")
@EditedEntityContainer("colorDc")
@LoadDataBeforeShow
public class ColorEdit extends StandardEditor<CarColor> {
}