package com.caseStudy.sortings;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class HashMapSortingByValue {

    public static void main(String args[]){
        Map<String, Integer> map = new HashMap<>();
        map.put("clothes", 120);
        map.put("grocery", 150);
        map.put("transportation", 100);
        map.put("utility", 130);
        map.put("rent", 1150);
        map.put("miscellneous", 90);

        System.out.println("map before sorting: " + map);

        Map<String, Integer> sorted = map.entrySet()
                .stream().sorted(comparingByValue())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2)-> e2, LinkedHashMap::new));

        System.out.println("map before sorting: " + sorted);

    }
}
