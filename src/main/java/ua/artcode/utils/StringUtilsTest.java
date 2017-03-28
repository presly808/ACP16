package main.java.ua.artcode.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Serhii Bilobrov
 * @since 1.7
 */
public class StringUtilsTest {

    public static void main(String[] args) {

        String in = "12,23,23,23,23";
        List<Integer> expected = Arrays.asList(12,23,23,23,23);

        List<Integer> actual = StringUtils.getIntArr(in);

        System.out.println(actual.equals(expected));

        System.out.printf("calling StringUtils.getIntArr(%s), expected %s, actual %s", in,
                Arrays.toString(expected.toArray()),
                actual.stream().map(Object::toString).collect(Collectors.joining(",")));

    }

}
