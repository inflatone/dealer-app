package ru.altarix.dealerapp.web.screens.contractor;

import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.screen.StandardLookup;
import ru.altarix.dealerapp.entity.contractor.Contractor;

import javax.inject.Inject;

public abstract class ContractorBrowse<E extends Contractor> extends StandardLookup<E> {
    @Inject
    protected ContractorRequestCountPrintableColumnGenerator contractorRequestCountPrintableColumnGenerator;

    protected void addRequestCountGeneratorColumn(GroupTable<E> table) {
        table.addGeneratedColumn("reqCount", contractorRequestCountPrintableColumnGenerator);
    }
}
