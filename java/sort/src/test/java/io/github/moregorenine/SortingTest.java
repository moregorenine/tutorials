package test.java.io.github.moregorenine;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class SortingTest {

    private HashMap<Integer, String> map;

    @Before
    public void initVariables() {
        map = new HashMap<>();
        map.put(55, "John");
        map.put(22, "Apple");
        map.put(66, "Earl");
        map.put(77, "Pearl");
        map.put(12, "George");
        map.put(6, "Rocky");
    }

    @Test
    public void givenMap_whenSortingByKeys_thenSortedMap() {
        Integer[] sortedKeys = new Integer[]{6, 12, 22, 55, 66, 77};

        List<Map.Entry<Integer, String>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Comparator.comparing(Map.Entry::getKey));
        HashMap<Integer, String> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, String> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        assertTrue(Arrays.equals(sortedMap.keySet()
                .toArray(), sortedKeys));
    }

    @Test
    public void givenMap_whenSortingByValues_thenSortedMap() {
        String[] sortedValues = new String[]{"Apple", "Earl", "George", "John", "Pearl", "Rocky"};

        List<Map.Entry<Integer, String>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Comparator.comparing(Map.Entry::getValue));
        HashMap<Integer, String> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, String> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        assertTrue(Arrays.equals(sortedMap.values()
                .toArray(), sortedValues));
    }
}