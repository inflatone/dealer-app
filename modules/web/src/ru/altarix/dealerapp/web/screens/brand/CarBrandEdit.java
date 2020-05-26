package ru.altarix.dealerapp.web.screens.brand;

import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.actions.list.CreateAction;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import ru.altarix.dealerapp.entity.car.CarBrand;
import ru.altarix.dealerapp.entity.car.CarConfiguration;
import ru.altarix.dealerapp.web.screens.configuration.CarConfigurationEdit;

import javax.inject.Inject;
import javax.inject.Named;

@UiController("dealerapp_CarBrand.edit")
@UiDescriptor("car-brand-edit.xml")
@EditedEntityContainer("carBrandDc")
public class CarBrandEdit extends StandardEditor<CarBrand> {
    @Inject
    private CollectionLoader<CarConfiguration> carConfigurationsDl;

    @Inject
    private ScreenBuilders screenBuilders;

    @Inject
    private Table<CarConfiguration> carConfigurationsTable;

    @Inject
    private InstanceContainer<CarBrand> carBrandDc;

    @Named("carConfigurationsTable.create")
    private CreateAction<CarConfiguration> carConfigurationsTableCreate;

    private boolean createMode = false;

    public void setCreateMode(boolean createMode) {
        this.createMode = createMode;
    }

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        disableCreateConfigurationIfNewEntity();
        carConfigurationsDl.setParameter("brand", getEditedEntity());
        getScreenData().loadAll();
    }

    // https://www.cuba-platform.com/discuss/t/cuba-7-passing-parameters-to-from-browser-to-edit-screen/8315/3
    @Subscribe("carConfigurationsTable.create")
    public void onCarConfigurationsTableCreate(Action.ActionPerformedEvent event) {
        CarConfigurationEdit editorScreen = screenBuilders.editor(carConfigurationsTable)
                .newEntity()
                .withScreenClass(CarConfigurationEdit.class)
                .withLaunchMode(OpenMode.DIALOG)
                .build();

        editorScreen.setActualCarBrand(carBrandDc.getItem());
        editorScreen.show();
    }

    private void disableCreateConfigurationIfNewEntity() {
        carConfigurationsTableCreate.setEnabled(!createMode);
    }
}