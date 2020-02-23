package ua.lviv.iot.fishing.model;

import ua.lviv.iot.fishing.model.accessories.WinterFishingLure;

public class IceRod extends AbstractFishingRod {

    private WinterFishingLure winterFishingLine;

    public IceRod(float lengthInMeters, Season season, float foldedLengthInMeters, int numberOfSection, String material, float weightInKg, WinterFishingLure winterFishingLine) {
        super(lengthInMeters, season, foldedLengthInMeters, numberOfSection, material, weightInKg);
        this.winterFishingLine = winterFishingLine;
    }

}
