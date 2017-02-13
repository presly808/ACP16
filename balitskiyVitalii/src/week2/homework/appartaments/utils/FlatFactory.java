package week2.homework.appartaments.utils;

import week2.homework.appartaments.model.Accessory;
import week2.homework.appartaments.model.District;
import week2.homework.appartaments.model.Flat;

import java.util.HashSet;

/**
 * Created by vitalii on 01.02.17.
 */
public class FlatFactory {
    private static Long id = 1L;

    public static Flat createFlat(){
        //id++;
        return new Flat(2, false, id, "Mendelleva 2", 80, "", new HashSet<Accessory>(), District.GOLOSIEVO, 3);

    }

}
