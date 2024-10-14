package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Quicksort {
    public static void main(String[] args){
        System.out.println(quicksort(Arrays.asList(9, 3, 5, 1, 6, 0)));
    }

    private static List<Integer> quicksort(List<Integer> list){
        if (list.size() < 2){
            // caso base
            return list;
        } else {
            // caso recursivo
            Integer pivot = list.getFirst();

            List<Integer> less = list.stream().skip(1).filter(el -> el <= pivot)
                    .collect(Collectors.toList());

            List<Integer> greater = list.stream().skip(1).filter(el -> el >= pivot)
                    .collect(Collectors.toList());
            return Stream.of(
                    quicksort(less).stream(),
                    Stream.of(pivot),
                    quicksort(greater).stream())
                    .flatMap(Function.identity()).collect(Collectors.toList());
        }
    }
}
