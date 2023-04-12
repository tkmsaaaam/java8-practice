package src;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    System.out.println("src.Main#main is started.");
    long start = System.nanoTime();
    System.out.println(start);

    // System.out.println("List");
    // List<Integer> list = preparedAlfaMethod();
    // System.out.println(System.nanoTime() - start);

    // System.out.println("Set");
    // Set<Integer> list = preparedAlfaMethod();
    // System.out.println(System.nanoTime() - start);

    System.out.println("Map");
    Map<Integer, Integer> list = preparedAlfaMethod();
    System.out.println(System.nanoTime() - start);
    comparedAlfaMethod(list);
    long end = System.nanoTime();
    System.out.println(end);
    System.out.println((end - start));
  }


  // --- List start ---

  // private static List<Integer> preparedAlfaMethod() {
  //   final Integer HUNDRED_THOUSAND = 100000;
  //   List<Integer> list = new ArrayList<>();
  //   for (int i = 0; i < HUNDRED_THOUSAND; i++) {
  //     list.add(i);
  //   }
  //   return list;
  // }

  // private static void comparedAlfaMethod(List<Integer> list) {
  //   final Integer HUNDRED_THOUSAND = 100000;
  //   for (int i = HUNDRED_THOUSAND - 1; i >= 0; i--) {
  //     int j = i;
  //     Integer result = list.stream().filter(num -> num == j).findFirst().orElse(null);
  //   }
  // }

  // --- List end ---

  // --- Set start ---

  // private static Set<Integer> preparedAlfaMethod() {
  //   final Integer HUNDRED_THOUSAND = 100000;
  //   Set<Integer> list = new HashSet<>();
  //   for (int i = 0; i < HUNDRED_THOUSAND; i++) {
  //     list.add(i);
  //   }
  //   return list;
  // }

  // private static void comparedAlfaMethod(Set<Integer> list) {
  //   final Integer HUNDRED_THOUSAND = 100000;
  //   for (int i = HUNDRED_THOUSAND - 1; i >= 0; i--) {
  //     int j = i;
  //     Integer result = list.stream().filter(num -> num == j).findFirst().orElse(null);
  //   }
  // }

  // --- Set end ---

  // --- Map start ---

  private static Map<Integer, Integer> preparedAlfaMethod() {
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
  Integer result = list.get(j);
  }
  }

  // --- Map end ---
}
