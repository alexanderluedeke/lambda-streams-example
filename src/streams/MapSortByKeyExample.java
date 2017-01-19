package streams;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class MapSortByKeyExample {

  public static void main(String[] args) {

    Map<String, String> countryCapitalMap = new HashMap<String, String>();
    countryCapitalMap.put("guyana", "georgetown");
    countryCapitalMap.put("nepal", "kathmandu");
    countryCapitalMap.put("australia", "canberra");
    countryCapitalMap.put("india", "new delhi");
    countryCapitalMap.put("japan", "tokyo");

    System.out.println("Original Map : \n" + countryCapitalMap);

    // Is later populated in lambda!
    Map<String, String> sortedMap = new LinkedHashMap<String, String>();

    countryCapitalMap.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByKey())
        .forEachOrdered(c -> sortedMap.put(c.getKey(), c.getValue()));

    System.out.println("Map sorted by key : \n" + sortedMap);
  }
}