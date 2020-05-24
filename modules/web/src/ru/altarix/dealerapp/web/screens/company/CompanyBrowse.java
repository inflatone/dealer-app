package ru.altarix.dealerapp.web.screens.company;

import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.screen.*;
import ru.altarix.dealerapp.entity.contractor.Company;
import ru.altarix.dealerapp.web.screens.contractor.ContractorBrowse;

import javax.inject.Inject;

@UiController("dealerapp_Company.browse")
@UiDescriptor("company-browse.xml")
@LookupComponent("companyTable")
@LoadDataBeforeShow
public class CompanyBrowse extends ContractorBrowse<Company> {
    @Inject
    private GroupTable<Company> companyTable;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        addRequestCountGeneratorColumn(companyTable);
        getScreenData().loadAll();
    }
}