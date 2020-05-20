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

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamePattern("%s|name")
@Table(name = "DEALERAPP_CAR_CONFIGURATION", uniqueConstraints = {
        @UniqueConstraint(name = "UNIQUE_BRAND_NAME_IDX", columnNames = {"CAR_BRAND_ID", "NAME"})
})
@Entity(name = "dealerapp_CarConfiguration")

public class CarConfiguration extends StandardEntity {
    private static final long serialVersionUID = 4768371649121367925L;

    @Column(name = "PRICE")
    @NotNull(message = "brand must be set")
    protected Integer price;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @Column(name = "CAR_TYPE")
    protected Integer carType;

    @Column(name = "COMMENT")
    protected String comment;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CAR_BRAND_ID")
    protected @NotNull CarBrand carBrand;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public CarType getCarType() {
        return carType == null ? null : CarType.fromId(carType);
    }

    public void setCarType(CarType carType) {
        this.carType = carType == null ? null : carType.getId();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}