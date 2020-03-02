package ua.lviv.iot.fishing.manager;

import java.util.LinkedList;
import java.util.List;
import ua.lviv.iot.fishing.model.AbstractFishingRod;
import ua.lviv.iot.fishing.model.Season;

public class FishingRodManager {

    private List<AbstractFishingRod> fishingRods = new LinkedList<>();

    public FishingRodManager(List<AbstractFishingRod> fishingRods) {
        this.fishingRods = fishingRods;
    }

    public FishingRodManager() {
    }

    public void addFishingRods(List<AbstractFishingRod> fishingRods) {
        this.fishingRods.addAll(fishingRods);
    }

    public void addFishingRod(AbstractFishingRod fishingRod) {
        this.fishingRods.add(fishingRod);
    }

    public List<AbstractFishingRod> findFishingRodForSeason(Season season) {

        List<AbstractFishingRod> result = new LinkedList<>();
        for (AbstractFishingRod fishingRod: fishingRods) {
            if (fishingRod.getSeason() == season) {
                result.add(fishingRod);
            }
        }
        return result;
    }

}
