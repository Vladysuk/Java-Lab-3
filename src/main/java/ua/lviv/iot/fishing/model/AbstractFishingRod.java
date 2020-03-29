package ua.lviv.iot.fishing.model;

public abstract class AbstractFishingRod implements Comparable<AbstractFishingRod> {

    private float lengthInMeters;
    private Season season;
    private float foldedLengthInMeters;
    private int numberOfSection;
    private float weightInKg;
    private Integer id;

    public AbstractFishingRod(float lengthInMeters, Season season, float foldedLengthInMeters, int numberOfSection, float weightInKg) {
        this.lengthInMeters = lengthInMeters;
        this.season = season;
        this.foldedLengthInMeters = foldedLengthInMeters;
        this.numberOfSection = numberOfSection;
        this.weightInKg = weightInKg;
    }
    public AbstractFishingRod(){
        this(0, Season.WINTER, 0, 0, 0);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getHeaders() {
        return "lengthInMeters, season, foldedLengthInMeters, numberOfSection, weightInKg";
    }

    public String toCSV() {
        return "lengthInMeters = " + getLengthInMeters() + ", " + "season = " + getSeason() + ", "
                + "foldedLengthInMeters = " + getFoldedLengthInMeters() + ", " + "numberOfSection = " + getNumberOfSection() + ", "
                + "weightInKg = " + getWeightInKg();
    }


}
