package ru.altarix.dealerapp.web.screens.request;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.View;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import org.apache.commons.collections4.ListUtils;
import ru.altarix.dealerapp.entity.car.Car;
import ru.altarix.dealerapp.entity.contractor.Company;
import ru.altarix.dealerapp.entity.contractor.Contractor;
import ru.altarix.dealerapp.entity.contractor.Person;
import ru.altarix.dealerapp.entity.request.Request;
import ru.altarix.dealerapp.service.ContractorNameComputingService;
import ru.altarix.dealerapp.web.SecurityUtils;
import ru.altarix.dealerapp.service.CarNameComputingService;

import javax.inject.Inject;
import java.util.List;

@UiController("dealerapp_Request.edit")
@UiDescriptor("request-edit.xml")
@EditedEntityContainer("requestDc")
@LoadDataBeforeShow
public class RequestEdit extends StandardEditor<Request> {
    @Inject
    private DataManager dataManager;

    @Inject
    private CollectionLoader<Car> carsDl;

    @Inject
    private CarNameComputingService carNameComputingService;

    @Inject
    private ContractorNameComputingService personNameComputingService;

    @Inject
    private LookupPickerField<Car> carField;

    @Inject
    private LookupPickerField<Contractor> personField;

    @Inject
    private SecurityUtils securityUtils;

    @Subscribe
    public void onInitEntity(InitEntityEvent<Request> event) {
        Request entity = event.getEntity();
        entity.setManager(securityUtils.getAuthUser());
    }

    @Subscribe
    public void onInit(InitEvent event) {
        List<Person> people = dataManager.load(Person.class).view(View.LOCAL).list();
        List<Company> companies = dataManager.load(Company.class).view(View.LOCAL).list();

        List<Contractor> contractors = ListUtils.union(people, companies);
        personNameComputingService.pasteTransientNames(contractors);
        personField.setOptionsList(contractors);

        carsDl.addPostLoadListener(e -> {
            List<Car> cars = e.getLoadedEntities();
            carNameComputingService.accept(cars);
            carField.setOptionsList(cars);
        });
    }


}