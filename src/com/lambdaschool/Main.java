package com.lambdaschool;

import java.util.*;

public class Main {

  public static void main(String[] args) {
    // Arrays => fixed length and fixed data types
    System.out.println("*** Arrays ***");
    Dog[] dogs = new Dog[5];

    dogs[0] = new Dog("Springer", 50, false);
    dogs[1] = new Dog("Bulldog", 50, true);
    dogs[2] = new Dog("Collie", 50, false);
    dogs[3] = new Dog("Boston Terrier", 35, true);
    dogs[4] = new Dog("Corgie", 35, true);

    for (int i = 0; i < dogs.length; i++) {
      System.out.println(dogs[i]);
    }

    // ArrayLists => unlimited size and fixed data types
    System.out.println("\n*** ArrayLists ***");
    ArrayList<Dog> dogArrayList = new ArrayList<Dog>();
    dogArrayList.addAll(Arrays.asList(dogs));
    dogArrayList.add(new Dog("Mutt", 15, true));

    for (Dog d : dogArrayList) {
      System.out.println(d);
    }

    // Adding and replacing elements in ArrayList
    System.out.println("***");
    dogArrayList.add(2, new Dog("Labrador", 75, false));
    dogArrayList.set(dogArrayList.size() - 1, new Dog("Pit Bull", 50, false));
    dogArrayList.forEach(d -> System.out.println(d));

    System.out.println("\n*** Sorting ArrayList ***");
    Collections.sort(dogArrayList, new Comparator<Dog>() {
      @Override
      public int compare(Dog o1, Dog o2) {
        return o1.getBreed().compareToIgnoreCase(o2.getBreed());
      }
    });

    for (Dog d : dogArrayList) {
      System.out.println(d);
    }

    // HashMaps => key, value (int), no order
    System.out.println("\n*** HashMap ***");
    HashMap<Integer, Dog> dogHashMap = new HashMap<Integer, Dog>();

    int hashCount = 0;
    for (Dog d : dogArrayList) {
      dogHashMap.put(hashCount, d);
      hashCount++;
    }

    dogArrayList.clear(); // free memory

    System.out.println(dogHashMap.get(3));
    System.out.println(dogHashMap.size());
    System.out.println(dogHashMap.remove(3));
    System.out.println(dogHashMap.get(3));

    System.out.println("***");
    for (Integer i : dogHashMap.keySet()) {
      System.out.println("Key=" + i + ", Value=" + dogHashMap.get(i));
    }

    System.out.println("\n*** Sort HashMap by avgWeight ***");
    ArrayList<HashMap.Entry<Integer, Dog>> sortedMap = new ArrayList<HashMap.Entry<Integer, Dog>>();
    sortedMap.addAll(dogHashMap.entrySet());

    Collections.sort(sortedMap, new Comparator<HashMap.Entry<Integer, Dog>>() {
      @Override
      public int compare(HashMap.Entry<Integer, Dog> o1, HashMap.Entry<Integer, Dog> o2) {
        return o1.getValue().getAvgWeight() - o2.getValue().getAvgWeight();
      }
    });

    for (HashMap.Entry<Integer, Dog> d : sortedMap) {
      System.out.println("Key=" + d.getKey() + ", Value=" + d.getValue());
    }
  }
}
