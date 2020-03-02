package ua.lviv.iot.fishing.manager;

import java.util.Comparator;
import java.util.List;
import ua.lviv.iot.fishing.model.AbstractFishingRod;
import ua.lviv.iot.fishing.model.SortType;



public class FishingRodManagerUtils {

    private static final RodSorterByNumberOfSection ROD_BY_NUMBER_OF_SECTION_SORTER = new RodSorterByNumberOfSection();

    private static class RodSorterByNumberOfSection implements Comparator<AbstractFishingRod> {

        @Override
        public int compare(AbstractFishingRod firstRod, AbstractFishingRod secondRod) {
            return firstRod.getNumberOfSection() - secondRod.getNumberOfSection();
        }
    }

    private class RodSorterByLengthInMeters implements Comparator<AbstractFishingRod> {

        @Override
        public int compare(AbstractFishingRod firstRod, AbstractFishingRod secondRod) {
            return firstRod.compareTo(secondRod);
        }
    }

    public static void sortByNumberOfSection(List<AbstractFishingRod> fishingRods, SortType sortType) {
        fishingRods.sort(sortType == SortType.ASC ? ROD_BY_NUMBER_OF_SECTION_SORTER : ROD_BY_NUMBER_OF_SECTION_SORTER.reversed());
    }

    public static void sortByLengthInMeters(List<AbstractFishingRod> fishingRods, SortType sortType) {
        fishingRods.sort(sortType == SortType.ASC ? new FishingRodManagerUtils().new RodSorterByLengthInMeters() :
                new FishingRodManagerUtils().new RodSorterByLengthInMeters().reversed());
    }

    public static void sortByWeightInKg(List<AbstractFishingRod> fishingRods, SortType sortType) {
        Comparator<AbstractFishingRod> rodSorterByWeightInKg = new Comparator<AbstractFishingRod>() {
            @Override
            public int compare(AbstractFishingRod firstRod, AbstractFishingRod secondRod) {
                return Float.compare(firstRod.getWeightInKg(), secondRod.getWeightInKg());
            }
        };
        fishingRods.sort(sortType == SortType.ASC ? rodSorterByWeightInKg : rodSorterByWeightInKg.reversed());
    }

    public static void sortRodByFoldedLength(List<AbstractFishingRod> fishingRods, SortType sortType) {
        if (sortType == SortType.ASC) {
            fishingRods.sort((firstRod, secondRod) -> Float.compare(firstRod.getFoldedLengthInMeters(), secondRod.getFoldedLengthInMeters()));
        } else {
            fishingRods.sort((firstRod, secondRod) -> Float.compare(secondRod.getFoldedLengthInMeters(), firstRod.getFoldedLengthInMeters()));
        }
    }

}


