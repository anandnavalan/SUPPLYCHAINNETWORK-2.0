package com.hcl.in;

import com.owlike.genson.annotation.JsonProperty;
import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;


@DataType
public final class Medicine {

    @Property()
    private final Long id;

    @Property()
    private final String name;

    @Property()
    private final String brandName;

    @Property
    private final String genericName;

    @Property()
    private final List chemicals;

    @Property
    private final String type;

    @Property
    private final double MRP;

    @Property
    private final double dealerPrice;

    @Property
    private final Owner owner;


    public Medicine() {
    }

    public Medicine(Long id, String name, String brandName, String genericName, List chemicals, String type, double MRP, double dealerPrice, Owner owner) {
        this.id = id;
        this.name = name;
        this.brandName = brandName;
        this.genericName = genericName;
        this.chemicals = chemicals;
        this.type = type;
        this.MRP = MRP;
        this.dealerPrice = dealerPrice;
        this.owner = owner;
    }

    public Long getId() {
        return this.id;
    }


    public String getName() {
        return this.name;
    }


    public String getBrandName() {
        return this.brandName;
    }


    public String getGenericName() {
        return this.genericName;
    }


    public List getChemicals() {
        return this.chemicals;
    }


    public String getType() {
        return this.type;
    }


    public double getMRP() {
        return this.MRP;
    }


    public double getDealerPrice() {
        return this.dealerPrice;
    }


    public Owner getOwner() {
        return this.owner;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Medicine)) {
            return false;
        }
        Medicine medicine = (Medicine) o;
        return Objects.equals(id, medicine.id) && Objects.equals(name, medicine.name) && Objects.equals(brandName, medicine.brandName) && Objects.equals(genericName, medicine.genericName) && Objects.equals(chemicals, medicine.chemicals) && Objects.equals(type, medicine.type) && MRP == medicine.MRP && dealerPrice == medicine.dealerPrice && Objects.equals(owner, medicine.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, brandName, genericName, chemicals, type, MRP, dealerPrice, owner);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", brandName='" + getBrandName() + "'" +
            ", genericName='" + getGenericName() + "'" +
            ", chemicals='" + getChemicals() + "'" +
            ", type='" + getType() + "'" +
            ", MRP='" + getMRP() + "'" +
            ", dealerPrice='" + getDealerPrice() + "'" +
            ", owner='" + getOwner() + "'" +
            "}";
    }
    
}