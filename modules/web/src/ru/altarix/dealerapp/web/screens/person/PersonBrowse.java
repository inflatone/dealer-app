package ru.altarix.dealerapp.web.screens.person;

import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.screen.*;
import ru.altarix.dealerapp.entity.contractor.Person;
import ru.altarix.dealerapp.web.screens.contractor.ContractorBrowse;

import javax.inject.Inject;

@UiController("dealerapp_Person.browse")
@UiDescriptor("person-browse.xml")
@LookupComponent("personTable")
@LoadDataBeforeShow
public class PersonBrowse extends ContractorBrowse<Person> {
    @Inject
    private GroupTable<Person> personTable;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        addRequestCountGeneratorColumn(personTable);
        getScreenData().loadAll();
    }
}