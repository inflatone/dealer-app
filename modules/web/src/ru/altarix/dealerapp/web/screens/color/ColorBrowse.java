package ru.altarix.dealerapp.web.screens.color;

import com.haulmont.cuba.gui.screen.*;
import ru.altarix.dealerapp.entity.car.CarColor;

@UiController("dealerapp_Color.browse")
@UiDescriptor("color-browse.xml")
@LookupComponent("colorsTable")
@LoadDataBeforeShow
public class ColorBrowse extends StandardLookup<CarColor> {
}