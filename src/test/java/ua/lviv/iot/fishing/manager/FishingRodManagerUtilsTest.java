package ua.lviv.iot.fishing.manager;

import org.junit.jupiter.api.Test;
import ua.lviv.iot.fishing.model.SortType;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FishingRodManagerUtilsTest extends BaseFishingRodManagerTest {

    @Test
    public void testSortingByLengthDescending(){
        FishingRodManagerUtils.sortByLengthInMeters(fishingRods, SortType.ASC);
        for(int i =0; i<fishingRods.size(); i++)
            System.out.println(fishingRods.get(i).getLengthInMeters());
        assertEquals(1.2f, fishingRods.get(0).getLengthInMeters());
        assertEquals(2.5f, fishingRods.get(1).getLengthInMeters());
        assertEquals(3.3f, fishingRods.get(2).getLengthInMeters());
    }
    @Test
    public void testSortingByNumberOfSectionDescending(){
        FishingRodManagerUtils.sortByNumberOfSection(fishingRods, SortType.DESC);
        for(int i =0; i<fishingRods.size(); i++)
            System.out.println(fishingRods.get(i).getNumberOfSection());
        assertEquals(5, fishingRods.get(0).getNumberOfSection());
        assertEquals(4, fishingRods.get(1).getNumberOfSection());
        assertEquals(3, fishingRods.get(2).getNumberOfSection());
    }
    @Test
    public void testSortingByWeightInKg(){
        FishingRodManagerUtils.sortByWeightInKg(fishingRods, SortType.DESC);
        for(int i =0; i<fishingRods.size(); i++)
            System.out.println(fishingRods.get(i).getWeightInKg());
        assertEquals(0.9f, fishingRods.get(0).getWeightInKg());
        assertEquals(0.8f, fishingRods.get(1).getWeightInKg());
        assertEquals(0.5f, fishingRods.get(2).getWeightInKg());
    }
    @Test
    public void testSortingRodByFoldedLength(){
        FishingRodManagerUtils.sortRodByFoldedLength(fishingRods, SortType.DESC);
        for(int i =0; i<fishingRods.size(); i++)
            System.out.println(fishingRods.get(i).getFoldedLengthInMeters());
        assertEquals(1f, fishingRods.get(0).getFoldedLengthInMeters());
        assertEquals(0.5f, fishingRods.get(1).getFoldedLengthInMeters());
        assertEquals(0.3f, fishingRods.get(2).getFoldedLengthInMeters());
    }


}
