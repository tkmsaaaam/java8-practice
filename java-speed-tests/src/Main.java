package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    System.out.println("src.Main#main is started.");

    System.out.println("List");
    long listStart = System.nanoTime();
    List<Integer> list = preparedAlfaMethodList();
    long listMid = System.nanoTime();
    comparedAlfaMethod(list);
    long listEnd = System.nanoTime();
    System.out.println(listMid - listStart);
    System.out.println(listEnd - listMid);
    System.out.println(listEnd - listStart);

    System.out.println("Set");
    long setStart = System.nanoTime();
    Set<Integer> set = preparedAlfaMethodSet();
    long setMid = System.nanoTime();
    comparedAlfaMethod(set);
    long setEnd = System.nanoTime();
    System.out.println(setMid - setStart);
    System.out.println(setEnd - setMid);
    System.out.println(setEnd - setStart);

    System.out.println("Map");
    long mapStart = System.nanoTime();
    Map<Integer, Integer> map = preparedAlfaMethodMap();
    long mapMid = System.nanoTime();
    comparedAlfaMethod(map);
    long mapEnd = System.nanoTime();
    System.out.println(mapMid - mapStart);
    System.out.println(mapEnd - mapMid);
    System.out.println(mapEnd - mapStart);

    System.out.println("src.Main#main is ended.");
  }


  // --- List start ---

  private static List<Integer> preparedAlfaMethodList() {
    final Integer HUNDRED_THOUSAND = 100000;
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < HUNDRED_THOUSAND; i++) {
      list.add(i);
    }
    return list;
  }

  private static void comparedAlfaMethod(List<Integer> list) {
    final Integer HUNDRED_THOUSAND = 100000;
    for (int i = HUNDRED_THOUSAND - 1; i >= 0; i--) {
      int j = i;
      list.stream().filter(num -> num == j).findFirst().orElse(null);
    }
  }

  // --- List end ---

  // --- Set start ---

  private static Set<Integer> preparedAlfaMethodSet() {
    final Integer HUNDRED_THOUSAND = 100000;
    Set<Integer> list = new HashSet<>();
    for (int i = 0; i < HUNDRED_THOUSAND; i++) {
      list.add(i);
    }
    return list;
  }

  private static void comparedAlfaMethod(Set<Integer> list) {
    final Integer HUNDRED_THOUSAND = 100000;
    for (int i = HUNDRED_THOUSAND - 1; i >= 0; i--) {
      int j = i;
      list.stream().filter(num -> num == j).findFirst().orElse(null);
    }
  }

  // --- Set end ---

  // --- Map start ---

  private static Map<Integer, Integer> preparedAlfaMethodMap() {
    final Integer HUNDRED_THOUSAND = 100000;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < HUNDRED_THOUSAND; i++) {
      map.put(i, i);
    }
    return map;
  }

  private static void comparedAlfaMethod(Map<Integer, Integer> list) {
    final Integer HUNDRED_THOUSAND = 100000;
    for (int i = HUNDRED_THOUSAND - 1; i >= 0; i--) {
      int j = i;
      list.get(j);
    }
  }

  // --- Map end ---
}
