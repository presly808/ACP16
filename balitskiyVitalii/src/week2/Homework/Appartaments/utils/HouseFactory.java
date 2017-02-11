package week2.Homework.Appartaments.utils;

import week2.Homework.Appartaments.model.Accessory;
import week2.Homework.Appartaments.model.District;
import week2.Homework.Appartaments.model.House;

import java.util.HashSet;

/**
 * Created by vitalii on 02.02.17.
 */
public class HouseFactory {
    private static Long id = 0L;

    public static House createHouse(){
        id++;
        return new House(id, "Hachturyana 15", 80, "", new HashSet<Accessory>(), District.GOLOSIEVO, 3, 125);
    }


}
