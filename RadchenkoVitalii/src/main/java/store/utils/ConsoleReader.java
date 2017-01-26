package store.utils;

import store.enums.ProductField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //TODO: to think?
    public Double enterDouble()  {
        try {
            return Double.parseDouble(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String enterLine()  {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public int enterInteger() {
        return Integer.parseInt(enterLine());
    }

    public  String enterData(int index, String fieldName)  {
        System.out.print(String.format("%d. %s: ", index, fieldName));
        return enterLine();
    }

    public  String enterData(int index, ProductField field)  {
        System.out.print(String.format("%d. %s: ", index, field.name()));
        return enterLine();
    }
}
