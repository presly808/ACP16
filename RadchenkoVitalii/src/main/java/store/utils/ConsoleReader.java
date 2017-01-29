package store.utils;

import store.enums.ProductField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final int MAX_ATTEMPT_NUMBER = 3;

    //TODO: hm? better way?
    public Double enterDouble()  {
        Double value = null;
        int count = 1;

        while (count <= MAX_ATTEMPT_NUMBER || value != null){
            try {
                String valueAsString = reader.readLine();
                value = Double.parseDouble(valueAsString);
            } catch (IOException e) {
                System.out.print("Error reading value. Please, enter again: ");
                count++;
            } catch (NumberFormatException e){
                System.out.println("Error parsing: Wrong format. Not Double. Please, enter again: ");
            }
        }

        return value;//throw Exception?
    }

    public String enterLine()  {
        String value = null;
        int count = 1;
        while (count <= MAX_ATTEMPT_NUMBER || value != null){
            try {
                value = reader.readLine();
                return value;
            } catch (IOException e) {
                System.out.print("Error reading value. Please, enter again: ");
                count++;
            }
        }

        return value;//throw Exception?
    }

    public Integer enterInteger() {
        Integer value = null;
        int count = 1;

        while (count <= MAX_ATTEMPT_NUMBER || value != null){
            try {
                String valueAsString = reader.readLine();
                value = Integer.parseInt(valueAsString);
            } catch (IOException e) {
                System.out.print("Error reading value. Please, enter again: ");
                count++;
            } catch (NumberFormatException e){
                System.out.println("Error parsing: Wrong format. Not Integer. Please, enter again: ");
            }
        }

        return value;//throw Exception?
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
