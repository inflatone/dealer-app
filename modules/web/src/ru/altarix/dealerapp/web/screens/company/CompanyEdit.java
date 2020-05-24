package ru.altarix.dealerapp.web.screens.company;

import com.haulmont.cuba.gui.screen.*;
import ru.altarix.dealerapp.entity.contractor.Company;

@UiController("dealerapp_Company.edit")
@UiDescriptor("company-edit.xml")
@EditedEntityContainer("companyDc")
@LoadDataBeforeShow
public class CompanyEdit extends StandardEditor<Company> {
}