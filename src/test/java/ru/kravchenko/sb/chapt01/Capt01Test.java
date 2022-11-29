
package ru.kravchenko.sb.chapt01;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Строки,числа и математика
 */
public class Capt01Test {

    /**
     * Подсчёт повторяющихся символов. Написать программу, которая подстчитывает повторяющиеся символы в заданной строке
     */
    @Test
    public void test01_01(){
        final String value = "Hello world ihaiha iha";
        final var count = countDuplicateCharacters01_01_01(value);
        final var count2 = countDuplicateCharacters01_01_02(value);
        assertNotNull(count);
        assertNotNull(count2);
    }

     private Map<Character, Integer> countDuplicateCharacters01_01_01(final String str){
        Map<Character, Integer> result = new HashMap<>();
         for (int i = 0; i < str.length(); i++) {
             char ch = str.charAt(i);
             result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
         }
        return result;
     }

    private Map<Character, Long> countDuplicateCharacters01_01_02(final String str){
        Map<Character, Long> result = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        return result;
    }

}
