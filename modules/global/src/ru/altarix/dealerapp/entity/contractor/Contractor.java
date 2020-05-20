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

package ru.altarix.dealerapp.entity.contractor;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@DiscriminatorValue("CONTRACTOR")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
@Table(name = "DEALERAPP_CONTRACTOR")
@Entity(name = "dealerapp_Contractor")
@NamePattern("%s|name")
public abstract class Contractor extends StandardEntity {
    private static final long serialVersionUID = 8463922120157520753L;

    @Column(name = "PHONE", length = 7)
    @Pattern(message = "field must contain 7 digits", regexp = "^[0-9]{7}$")
    protected String phone;

    @Transient
    @MetaProperty
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}