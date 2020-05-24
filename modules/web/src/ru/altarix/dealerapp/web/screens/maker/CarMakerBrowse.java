package ru.altarix.dealerapp.web.screens.maker;

import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import ru.altarix.dealerapp.entity.car.CarMaker;
import ru.altarix.dealerapp.service.CarMakerTransientValuesComputingService;

import javax.inject.Inject;

@UiController("dealerapp_CarMaker.browse")
@UiDescriptor("maker-browse.xml")
@LookupComponent("makersTable")
@LoadDataBeforeShow
public class CarMakerBrowse extends StandardLookup<CarMaker> {
    @Inject
    private CollectionContainer<CarMaker> makersDc;

    @Inject
    private CollectionLoader<CarMaker> makersDl;

    @Inject
    private CarMakerTransientValuesComputingService carMakerTransientValuesComputingService;

    @Subscribe
    protected void onInit(InitEvent event) {
        makersDl.addPostLoadListener(e -> carMakerTransientValuesComputingService.pasteCarBrandCounts(e.getLoadedEntities()));
        makersDc.addCollectionChangeListener(e -> carMakerTransientValuesComputingService.pasteCarBrandCounts(e.getChanges()));
    }
}