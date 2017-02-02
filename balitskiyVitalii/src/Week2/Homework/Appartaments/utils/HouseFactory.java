package Week2.Homework.Appartaments.utils;

import Week2.Homework.Appartaments.model.Accessory;
import Week2.Homework.Appartaments.model.District;
import Week2.Homework.Appartaments.model.House;

import java.util.HashSet;

/**
 * Created by vitalii on 02.02.17.
 */
public class HouseFactory {

    public static House createHouse(){
        return new House(1, "Hachturyana 15", 80, "", new HashSet<Accessory>(), District.GOLOSIEVO, 3, 125);
    }


}
