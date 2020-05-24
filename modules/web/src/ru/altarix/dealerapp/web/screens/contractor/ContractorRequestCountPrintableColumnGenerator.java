package ru.altarix.dealerapp.web.screens.contractor;

import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.components.Table;
import ru.altarix.dealerapp.entity.contractor.Contractor;
import ru.altarix.dealerapp.service.ContractorDataComputingService;

import javax.inject.Inject;

@org.springframework.stereotype.Component(ContractorRequestCountPrintableColumnGenerator.NAME)
public class ContractorRequestCountPrintableColumnGenerator implements Table.PrintableColumnGenerator<Contractor, Integer> {
    public static final String NAME = "dealerapp_PersonRequestCountPrintableColumnGenerator";

    @Inject
    private ContractorDataComputingService contractorDataComputingService;

    @Inject
    private UiComponents uiComponents;

    @Override
    public Component generateCell(Contractor person) {
        Label<Integer> field = uiComponents.create(Label.NAME);
        field.setValue(contractorDataComputingService.computeRequestAmount(person));
        return field;
    }

    @Override
    public Integer getValue(Contractor person) {
        return contractorDataComputingService.computeRequestAmount(person);
    }
}
