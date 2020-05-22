package ru.altarix.dealerapp.config;

import com.haulmont.cuba.core.config.Config;
import com.haulmont.cuba.core.config.Property;
import com.haulmont.cuba.core.config.Source;
import com.haulmont.cuba.core.config.SourceType;
import com.haulmont.cuba.core.config.defaults.Default;
import ru.altarix.dealerapp.entity.Country;

@Source(type = SourceType.DATABASE)
public interface DefaultValueConfig extends Config {

    @Property("app.defaultCountry")
    @Default("dealerapp_Country-0ff2af01-0864-fca9-17e3-61795c76bf26")
    Country getDefaultCountry();

    void setDefaultCountry(Country country);
}
