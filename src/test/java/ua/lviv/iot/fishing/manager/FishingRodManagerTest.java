package ua.lviv.iot.fishing.manager;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import ua.lviv.iot.fishing.model.AbstractFishingRod;
import ua.lviv.iot.fishing.model.Season;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FishingRodManagerTest extends BaseFishingRodManagerTest {
    private FishingRodManager fishingRodManager;
    @BeforeEach
    public void SetUp(){
        fishingRodManager = new FishingRodManager();
        fishingRodManager.addFishingRods(fishingRods);
    }
    @Test
    public void findFishingRodForSeason(){
        List<AbstractFishingRod> abstractFishingRods = fishingRodManager.findFishingRodForSeason(Season.SUMMER);
        assertEquals(2, fishingRods.size());

        //sort result

        // verify fishing rods season
        assertEquals(Season.SUMMER, fishingRods.get(0).getSeason());
        assertEquals(Season.SUMMER, fishingRods.get(1).getSeason());

    }


}