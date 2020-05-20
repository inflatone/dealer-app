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

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NamePattern("%s|name")
@Table(name = "DEALERAPP_CAR_BRAND", uniqueConstraints = {
        @UniqueConstraint(name = "UNIQUE_NAME_CAR_MAKER_IDX", columnNames = {"CAR_MAKER_ID", "NAME"})
})
@Entity(name = "dealerapp_CarBrand")
public class CarBrand extends StandardEntity {
    private static final long serialVersionUID = -8000938349343824167L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CAR_MAKER_ID")
    protected CarMaker carMaker;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "carBrand")
    protected List<CarConfiguration> carConfigurations;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CarConfiguration> getCarConfigurations() {
        return carConfigurations;
    }

    public void setCarConfigurations(List<CarConfiguration> carConfigurations) {
        this.carConfigurations = carConfigurations;
    }

    public CarMaker getCarMaker() {
        return carMaker;
    }

    public void setCarMaker(CarMaker carMaker) {
        this.carMaker = carMaker;
    }
}