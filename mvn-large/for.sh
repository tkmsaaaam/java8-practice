#!/bin/sh

ALPHABET=("a" "b" "c" "d" "e" "f" "g" "h" "i" "j" "k" "l" "m" "n" "o" "p" "q" "r" "s" "t" "u" "v" "w" "x" "y" "z")

#ALPHABET=("a" "b" "c" "d" "e" "f" "g" "h" "i" "j" "k" "l" "m" "n" "o" )

mkdir src/main/java/sub

for i in "${ALPHABET[@]}"; do
  for j in "${ALPHABET[@]}"; do
    for k in "${ALPHABET[@]}"; do
      STR=`echo $i$j$k| tr '[a-z]' '[A-Z]'`
      echo "package sub;

      public class $STR {
          public static void main(String[] args) {
              System.out.println(\"$STR\");
          }

          public static void mainA(String[] args) {
              System.out.println(\"$STR\");
          }

          public static void mainB(String[] args) {
              System.out.println(\"$STR\");
          }

          public static void mainD(String[] args) {
              System.out.println(\"$STR\");
          }

          public static void mainE(String[] args) {
              System.out.println(\"$STR\");
          }

          public static void mainF(String[] args) {
              System.out.println(\"$STR\");
          }

          public static void mainG(String[] args) {
              System.out.println(\"$STR\");
          }

          public static void mainH(String[] args) {
              System.out.println(\"$STR\");
          }

          public static void mainI(String[] args) {
              System.out.println(\"$STR\");
          }

      }
      " >> src/main/java/sub/${STR}.java
    done
  done
done
