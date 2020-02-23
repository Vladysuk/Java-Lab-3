package ua.lviv.iot.fishing.manager;

import org.junit.jupiter.api.BeforeEach;
import ua.lviv.iot.fishing.model.*;

import java.util.LinkedList;
import java.util.List;

class BaseFishingRodManagerTest {
    protected List <AbstractFishingRod> fishingRods;
    @BeforeEach
    public void createFishingRods(){
     fishingRods = new LinkedList<AbstractFishingRod>();
     fishingRods.add(new IceRod(1, Season.WINTER,0.3f, 4, "steel", 0.5f, null));
     fishingRods.add(new Spinning(2, Season.SUMMER,1f, 3, "steel", 0.8f, null));
     fishingRods.add(new FloatRod(3, Season.SUMMER,0.5f, 5, "steel", 0.8f, null));
    }

}