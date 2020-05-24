package ru.altarix.dealerapp.web.screens.request;

import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.model.CollectionChangeType;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import ru.altarix.dealerapp.entity.car.Car;
import ru.altarix.dealerapp.entity.contractor.Contractor;
import ru.altarix.dealerapp.entity.request.Request;
import ru.altarix.dealerapp.service.CarNameComputingService;
import ru.altarix.dealerapp.service.ContractorNameComputingService;

import javax.inject.Inject;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@UiController("dealerapp_Request.browse")
@UiDescriptor("request-browse.xml")
@LookupComponent("requestsTable")
@LoadDataBeforeShow
public class RequestBrowse extends StandardLookup<Request> {
    @Inject
    private CarNameComputingService carNameComputingService;

    @Inject
    private ContractorNameComputingService contractorNameComputingService;

    @Inject
    private GroupTable<Request> requestsTable;

    @Subscribe(id = "requestsDc", target = Target.DATA_CONTAINER)
    public void onRequestsDcCollectionChange(CollectionContainer.CollectionChangeEvent<Request> event) {
        if (event.getChangeType() == CollectionChangeType.SET_ITEM
                || event.getChangeType() == CollectionChangeType.ADD_ITEMS) {
            Collection<? extends Request> changes = event.getChanges();
            initTransientCarNames(changes);
            initTransientPersonNames(changes);
            requestsTable.repaint();
            requestsTable.setSelected(changes.iterator().next());
        }
    }

    @Subscribe(id = "requestsDl", target = Target.DATA_LOADER)
    public void onRequestsDlPostLoad(CollectionLoader.PostLoadEvent<Request> event) {
        List<Request> loadedEntities = event.getLoadedEntities();
        initTransientCarNames(loadedEntities);
        initTransientPersonNames(loadedEntities);
    }

    private void initTransientPersonNames(Collection<? extends Request> requests) {
        List<Contractor> people = requests.stream()
                .map(Request::getContractor)
                .collect(Collectors.toList());
        contractorNameComputingService.pasteTransientNames(people);
    }

    private void initTransientCarNames(Collection<? extends Request> requests) {
        List<Car> cars = requests.stream().map(Request::getCar).collect(Collectors.toList());
        carNameComputingService.accept(cars);
    }
}