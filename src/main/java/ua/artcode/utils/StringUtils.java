package main.java.ua.artcode.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Serhii Bilobrov
 * @since 1.7
 */
public final class StringUtils {

    private static final String SEPARATOR = ",";

    private StringUtils() {}

    //     12,34,54,56,67,878,98
    public static List<Integer> getIntArr(String src){

        if(src == null || src.isEmpty()){
            throw new NullPointerException();
        }

        String trimmed = src.trim();

        String[] numbersStr = trimmed.split(SEPARATOR);

        List<Integer> list =
                Arrays.stream(numbersStr).map(Integer::parseInt).collect(Collectors.toList());

        return list;

    }

}
