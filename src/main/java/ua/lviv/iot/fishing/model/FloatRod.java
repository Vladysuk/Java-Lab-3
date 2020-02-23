package ua.lviv.iot.fishing.model;

import ua.lviv.iot.fishing.model.accessories.FishingFloat;

public class FloatRod extends AbstractFishingRod {

    private FishingFloat fishingFloat;

    public FloatRod(float lengthInMeters, Season season, float foldedLengthInMeters, int numberOfSection, String material, float weightInKg, FishingFloat fishingFloat) {
        super(lengthInMeters, season, foldedLengthInMeters, numberOfSection, material, weightInKg);
        this.fishingFloat = fishingFloat;
    }

}

