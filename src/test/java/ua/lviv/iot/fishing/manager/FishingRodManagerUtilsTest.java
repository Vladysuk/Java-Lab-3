package ua.lviv.iot.fishing.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.fishing.model.SortType;

import static org.junit.jupiter.api.Assertions.*;

class FishingRodManagerUtilsTest extends BaseFishingRodManagerTest {

    @Test
    public void testSortingByLengthDescending(){
        FishingRodManagerUtils.sortByLength(fishingRods, SortType.DESC);
        assertEquals(3, fishingRods.get(0).getLengthInMeters());
        assertEquals(2, fishingRods.get(1).getLengthInMeters());
        assertEquals(1, fishingRods.get(2).getLengthInMeters());
    }
    @Test
    public void testSortingByNumberOfSectionDescending(){
        FishingRodManagerUtils.SortByNumberOfSection(fishingRods, SortType.DESC);
        assertEquals(5, fishingRods.get(0).getNumberOfSection());
        assertEquals(4, fishingRods.get(1).getNumberOfSection());
        assertEquals(3, fishingRods.get(2).getNumberOfSection());
    }

}
