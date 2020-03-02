package ua.lviv.iot.fishing.model;

public abstract class AbstractFishingRod implements Comparable<AbstractFishingRod> {

    private float lengthInMeters;
    private Season season;
    private float foldedLengthInMeters;
    private int numberOfSection;
    private float weightInKg;

    public AbstractFishingRod(float lengthInMeters, Season season, float foldedLengthInMeters, int numberOfSection, float weightInKg) {
        this.lengthInMeters = lengthInMeters;
        this.season = season;
        this.foldedLengthInMeters = foldedLengthInMeters;
        this.numberOfSection = numberOfSection;
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

    public float getWeightInKg() {
        return weightInKg;
    }

    public float getFoldedLengthInMeters() {
        return foldedLengthInMeters;
    }

    @Override
    public int compareTo(AbstractFishingRod another) {
        return Float.compare(this.getLengthInMeters(), another.getLengthInMeters());
    }




}
