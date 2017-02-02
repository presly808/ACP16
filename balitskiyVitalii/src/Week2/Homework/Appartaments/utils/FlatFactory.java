package Week2.Homework.Appartaments.utils;

import Week2.Homework.Appartaments.model.Flat;

/**
 * Created by vitalii on 01.02.17.
 */
public class FlatFactory {

    public static Flat createFlat(){
        return new Flat(2, false);
    }

}
