package ua.lviv.iot.fishing.model;

import javax.persistence.Entity;

@Entity
public class IceRod extends AbstractFishingRod {

    private String typeOfFishingLure;

    public IceRod() {
    }

    public IceRod(float lengthInMeters, Season season, float foldedLengthInMeters, int numberOfSection, float weightInKg, String typeOfFishingLure, IceRodSet iceRodSet) {
        super(lengthInMeters, season, foldedLengthInMeters, numberOfSection, weightInKg, iceRodSet);
        this.typeOfFishingLure = typeOfFishingLure;
    }

    public String getTypeOfFishingLure() {
        return typeOfFishingLure;
    }

    public String getHeaders() {
        return super.getHeaders() + ", typeOfFishingLure";
    }

    public String toCSV() {
        return super.toCSV() + ", " + "typeOfFishingLure = " + getTypeOfFishingLure();
    }

}
