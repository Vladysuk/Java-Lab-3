package ua.lviv.iot.fishing.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
public abstract class AbstractFishingRod implements Comparable<AbstractFishingRod> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "iceRodSet_id")
    @JsonIgnoreProperties("iceRods")
    private IceRodSet iceRodSet;

    @ManyToMany(mappedBy = "iceRods")
    @JsonIgnoreProperties("iceRods")
    private Set<IceRodShop> iceRodShops;

    @Enumerated(EnumType.STRING)
    private Season season;

    private float lengthInMeters;
    private float foldedLengthInMeters;
    private int numberOfSection;
    private float weightInKg;

    public AbstractFishingRod(float lengthInMeters, Season season, float foldedLengthInMeters, int numberOfSection, float weightInKg, IceRodSet iceRodSet) {
        this.lengthInMeters = lengthInMeters;
        this.season = season;
        this.foldedLengthInMeters = foldedLengthInMeters;
        this.numberOfSection = numberOfSection;
        this.weightInKg = weightInKg;
        this.iceRodSet = iceRodSet;
    }

    public AbstractFishingRod(float lengthInMeters, Season season, float foldedLengthInMeters, int numberOfSection, float weightInKg) {
        this(lengthInMeters, season, foldedLengthInMeters, numberOfSection, weightInKg, null);
    }

    public AbstractFishingRod() {
        this(0, Season.WINTER, 0, 0, 0);
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

    public IceRodSet getIceRodSet() {
        return iceRodSet;
    }

    public void setIceRodSet(IceRodSet iceRodSet) {
        this.iceRodSet = iceRodSet;
    }

    public Set<IceRodShop> getIceRodShops() {
        return iceRodShops;
    }

    public void setIceRodShops(Set<IceRodShop> iceRodShops) {
        this.iceRodShops = iceRodShops;
    }

    @Override
    public int compareTo(AbstractFishingRod another) {
        return Float.compare(this.getLengthInMeters(), another.getLengthInMeters());
    }

    public String getHeaders() {
        return "lengthInMeters, season, foldedLengthInMeters, numberOfSection, weightInKg";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String toCSV() {
        return "lengthInMeters = " + getLengthInMeters() + ", " + "season = " + getSeason() + ", "
                + "foldedLengthInMeters = " + getFoldedLengthInMeters() + ", " + "numberOfSection = " + getNumberOfSection() + ", "
                + "weightInKg = " + getWeightInKg();
    }

}
