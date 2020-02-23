package ua.lviv.iot.fishing.model;

import ua.lviv.iot.fishing.model.accessories.Wobbler;

public class Spinning extends AbstractFishingRod {

    private Wobbler wobbler;

    public Spinning(float lengthInMeters, Season season, float foldedLengthInMeters, int numberOfSection, String material, float weightInKg, Wobbler wobbler) {
        super(lengthInMeters, season, foldedLengthInMeters, numberOfSection, material, weightInKg);
        this.wobbler = wobbler;
    }

}
