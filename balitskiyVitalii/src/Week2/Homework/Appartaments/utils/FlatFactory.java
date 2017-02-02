package Week2.Homework.Appartaments.utils;

import Week2.Homework.Appartaments.model.Accessory;
import Week2.Homework.Appartaments.model.District;
import Week2.Homework.Appartaments.model.Flat;

import java.util.HashSet;

/**
 * Created by vitalii on 01.02.17.
 */
public class FlatFactory {

    public static Flat createFlat(){
        return new Flat(2, false, 1, "Mendelleva 2", 80, "", new HashSet<Accessory>(), District.GOLOSIEVO, 3);
    }

}
