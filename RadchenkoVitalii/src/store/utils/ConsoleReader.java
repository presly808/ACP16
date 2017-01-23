package store.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

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
}
