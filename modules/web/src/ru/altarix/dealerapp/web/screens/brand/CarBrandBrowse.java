package ru.altarix.dealerapp.web.screens.brand;

import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.screen.*;
import ru.altarix.dealerapp.entity.car.CarBrand;

import javax.inject.Inject;

@UiController("dealerapp_CarBrand.browse")
@UiDescriptor("car-brand-browse.xml")
@LookupComponent("carBrandsTable")
@LoadDataBeforeShow
public class CarBrandBrowse extends StandardLookup<CarBrand> {
    @Inject
    private ScreenBuilders screenBuilders;

    @Inject
    private GroupTable<CarBrand> carBrandsTable;

    @Subscribe("carBrandsTable.create")
    public void onCarBrandsTableCreate(Action.ActionPerformedEvent event) {
        CarBrandEdit editorScreen = screenBuilders.editor(carBrandsTable)
                .newEntity()
                .withScreenClass(CarBrandEdit.class)
                .build();

        editorScreen.setCreateMode(true);
        editorScreen.show();
    }

}