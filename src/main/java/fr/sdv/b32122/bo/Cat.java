package fr.sdv.b32122.bo;

import javax.persistence.Entity;

@Entity
public class Cat extends Animal {
    private String chipId;

    public Cat() {}

    public Cat( String chipId ) {
        this.chipId = chipId;
    }

    public String getChipId() {
        return chipId;
    }

    public void setChipId( String chipId ) {
        this.chipId = chipId;
    }
}
