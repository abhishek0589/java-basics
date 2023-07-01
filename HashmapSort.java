/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;

/**
 *
 * @author Javin Paul
 */
public class SortingMapByValueInJava8 {

  /**
   * @param args
   * the command line arguments
   */
  public static void main(String[] args) {

    // Creating a Map with electoric items and prices
    Map<String, Integer> ItemToPrice = new HashMap<>();
    ItemToPrice.put("Sony Braiva", 1000);
    ItemToPrice.put("Apple iPhone 6S", 1200);
    ItemToPrice.put("HP Laptop", 700);
    ItemToPrice.put("Acer HD Monitor", 139);
    ItemToPrice.put("Samsung Galaxy", 800);

    System.out.println("unsorted Map: " + ItemToPrice);

    // sorting Map by values in ascending order, price here
    ItemToPrice.entrySet().stream()
        .sorted(Map.Entry.<String, Integer> comparingByValue())
        .forEach(System.out::println);

    // now, let's collect the sorted entries in Map
    Map<String, Integer> sortedByPrice = ItemToPrice.entrySet().stream()
        .sorted(Map.Entry.<String, Integer> comparingByValue())
        .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

    System.out.println("Map incorrectly sorted by value in ascending order: "
        + sortedByPrice);

    // the Map returned by the previous statement was not sorted
    // because ordering was lost while collecting result in Map
    // you need to use the LinkedHashMap to preserve the order

    Map<String, Integer> sortedByValue = ItemToPrice
        .entrySet()
        .stream()
        .sorted(Map.Entry.<String, Integer> comparingByValue())
        .collect(
            toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
                LinkedHashMap::new));

    System.out.println("Map sorted by value in increasing order: "
        + sortedByValue);

    // sorting a Map by values in descending order
    // just reverse the comparator sorting by using reversed() method
    Map<String, Integer> sortedByValueDesc = ItemToPrice
        .entrySet()
        .stream()
        .sorted(Map.Entry.<String, Integer> comparingByValue().reversed())
        .collect(
            toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
                LinkedHashMap::new));

    System.out.println("Map sorted by value in descending order: "
        + sortedByValueDesc);
  }

}

/*
Output
unsorted Map: {Samsung Galaxy=800, HP Laptop=700, Sony Braiva=1000,
               Acer HD Monitor=139, Apple iPhone 6S=1200}
Acer HD Monitor=139
HP Laptop=700
Samsung Galaxy=800
Sony Braiva=1000
Apple iPhone 6S=1200
Map incorrectly sorted by value in ascending order: 
{Samsung Galaxy=800, HP Laptop=700, Sony Braiva=1000, 
Acer HD Monitor=139, Apple iPhone 6S=1200}
Map sorted by value in increasing order: 
{Acer HD Monitor=139, HP Laptop=700, Samsung Galaxy=800, 
Sony Braiva=1000, Apple iPhone 6S=1200}
Map sorted by value in descending order: {Apple iPhone 6S=1200,
 Sony Braiva=1000, Samsung Galaxy=800, HP Laptop=700, Acer HD Monitor=139}
*/
