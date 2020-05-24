package ru.altarix.dealerapp.web.screens.person;

import com.haulmont.cuba.gui.screen.*;
import ru.altarix.dealerapp.entity.contractor.Person;

@UiController("dealerapp_Person.edit")
@UiDescriptor("person-edit.xml")
@EditedEntityContainer("personDc")
@LoadDataBeforeShow
public class PersonEdit extends StandardEditor<Person> {
}