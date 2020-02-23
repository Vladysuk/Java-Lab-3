package ua.lviv.iot.fishing.model;

public abstract class AbstractFishingRod {

    private float lengthInMeters;
    private Season season;
    private float foldedLengthInMeters;
    private int numberOfSection;
    private String material;
    private float weightInKg;

    public AbstractFishingRod(float lengthInMeters, Season season, float foldedLengthInMeters, int numberOfSection, String material, float weightInKg) {
        this.lengthInMeters = lengthInMeters;
        this.season = season;
        this.foldedLengthInMeters = foldedLengthInMeters;
        this.numberOfSection = numberOfSection;
        this.material = material;
        this.weightInKg = weightInKg;
    }

    public float getLengthInMeters() {
        return lengthInMeters;
    }

    public Season getSeason() {
        return season;
    }

    public int getNumberOfSection() {
        return numberOfSection;
    }

}
