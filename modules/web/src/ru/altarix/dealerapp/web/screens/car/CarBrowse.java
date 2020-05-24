package ru.altarix.dealerapp.web.screens.car;

import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import ru.altarix.dealerapp.entity.car.Car;
import ru.altarix.dealerapp.service.CarNameComputingService;

import javax.inject.Inject;

@UiController("dealerapp_Car.browse")
@UiDescriptor("car-browse.xml")
@LookupComponent("carsTable")
@LoadDataBeforeShow
public class CarBrowse extends StandardLookup<Car> {
    @Inject
    private CollectionLoader<Car> carsDl;

    @Inject
    private CollectionContainer<Car> carsDc;

    @Inject
    private CarNameComputingService carNameComputingService;

    @Subscribe
    protected void onInit(InitEvent event) {
        carsDc.addCollectionChangeListener(e -> carNameComputingService.accept(e.getChanges()));
        carsDl.addPostLoadListener(e -> carNameComputingService.accept(e.getLoadedEntities()));
    }
}