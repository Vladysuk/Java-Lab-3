package ua.lviv.iot.fishing.model;

public class Spinning extends AbstractFishingRod {

    private String typeOfWobbler;

    public Spinning(float lengthInMeters, Season season, float foldedLengthInMeters, int numberOfSection, float weightInKg, String typeOfWobbler) {
        super(lengthInMeters, season, foldedLengthInMeters, numberOfSection, weightInKg);
        this.typeOfWobbler = typeOfWobbler;
    }

    public String getTypeOfWobbler() {
        return typeOfWobbler;
    }

    public String getHeaders() {
        return super.getHeaders() + ", typeOfWobbler";
    }

    public String toCSV() {
        return super.toCSV() + ", " + "typeOfWobbler = " + getTypeOfWobbler();
    }
}
