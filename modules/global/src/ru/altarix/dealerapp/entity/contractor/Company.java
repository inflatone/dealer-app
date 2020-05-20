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

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@DiscriminatorValue("COMPANY")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
@Table(name = "DEALERAPP_COMPANY")
@Entity(name = "dealerapp_Company")
public class Company extends Contractor {
    private static final long serialVersionUID = 3079221704457790039L;

    @Column(name = "TITLE")
    protected String title;

    @Column(name = "INN", length = 12)
    @Pattern(message = "field must contain 12 digits", regexp = "^[0-9]{12}$")
    protected String inn;

    @Lob
    @Column(name = "ADDRESS")
    protected String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}