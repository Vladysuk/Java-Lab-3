package ua.lviv.iot.fishing.manager;

import org.junit.jupiter.api.BeforeEach;
import ua.lviv.iot.fishing.model.*;

import java.util.LinkedList;
import java.util.List;

public class BaseFishingRodManagerTest {
    protected List <AbstractFishingRod> fishingRods;
    @BeforeEach
    public void createFishingRods(){
     fishingRods = new LinkedList<AbstractFishingRod>();
     fishingRods.add(new Spinning(2.5f, Season.SUMMER,0.5f, 3, 0.9f, ""));
     fishingRods.add(new FloatRod(3.3f, Season.SUMMER,1f, 5, 0.5f,""));
     fishingRods.add(new IceRod(1.2f, Season.WINTER,0.3f, 4, 0.8f,"", null));
    }

}