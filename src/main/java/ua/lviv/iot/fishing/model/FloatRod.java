package ua.lviv.iot.fishing.model;

public class FloatRod extends AbstractFishingRod {

    private String typeOfFishingFloat;

    public FloatRod(float lengthInMeters, Season season, float foldedLengthInMeters, int numberOfSection, float weightInKg, String typeOfFishingFloat) {
        super(lengthInMeters, season, foldedLengthInMeters, numberOfSection, weightInKg);
        this.typeOfFishingFloat = typeOfFishingFloat;
    }

    public String getTypeOfFishingFloat() {
        return typeOfFishingFloat;
    }

    public String getHeaders() {
        return super.getHeaders() + ", typeOfFishingFloat";
    }

    public String toCSV() {
        return super.toCSV() + ", " + "typeOfFishingFloat = " + getTypeOfFishingFloat();
    }

}

