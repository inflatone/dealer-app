/*
 * Copyright (c) 2008-2020 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package ru.altarix.dealerapp.entity.car;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import ru.altarix.dealerapp.entity.Country;
import ru.altarix.dealerapp.entity.NamedCodedEntity;

import javax.persistence.*;

@NamePattern("%s|name")
@Table(name = "DEALERAPP_CAR_MAKER")
@Entity(name = "dealerapp_CarMaker")
public class CarMaker extends NamedCodedEntity {
    private static final long serialVersionUID = 672352106149447127L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COUNTRY_ID")
    protected Country country;

    @Transient
    @MetaProperty
    protected Long brandCount;

    public void setBrandCount(Long brandCount) {
        this.brandCount = brandCount;
    }

    public Long getBrandCount() {
        return brandCount;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}