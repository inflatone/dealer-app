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
import com.haulmont.chile.core.annotations.NumberFormat;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamePattern("%s|name")
@Table(name = "DEALERAPP_CAR")
@Entity(name = "dealerapp_Car")
public class Car extends StandardEntity {
    private static final long serialVersionUID = -2843443761653030720L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CAR_MAKER_ID")
    protected @NotNull CarMaker carMaker;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CAR_BRAND_ID")
    protected @NotNull CarBrand carBrand;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CAR_CONFIGURATION_ID")
    protected CarConfiguration carConfiguration;

    @Transient
    @MetaProperty
    protected String name;

    @NumberFormat(pattern = "#")
    @Column(name = "YEAR", nullable = false)
    protected @NotNull Integer year;

    @Column(name = "PRICE", nullable = false)
    protected @NotNull Integer price;

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarConfiguration getCarConfiguration() {
        return carConfiguration;
    }

    public void setCarConfiguration(CarConfiguration carConfiguration) {
        this.carConfiguration = carConfiguration;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }

    public CarMaker getCarMaker() {
        return carMaker;
    }

    public void setCarMaker(CarMaker carMaker) {
        this.carMaker = carMaker;
    }
}