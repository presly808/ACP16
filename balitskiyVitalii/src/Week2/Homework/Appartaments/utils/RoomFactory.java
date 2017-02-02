package Week2.Homework.Appartaments.utils;

import Week2.Homework.Appartaments.model.Accessory;
import Week2.Homework.Appartaments.model.District;
import Week2.Homework.Appartaments.model.House;
import Week2.Homework.Appartaments.model.Room;

import java.util.HashSet;

/**
 * Created by vitalii on 02.02.17.
 */
public class RoomFactory {
    public static Room createRoom() {
        return new Room(1, "Metalistov 15", 22, "good room", new HashSet<Accessory>(), District.SVYATOSHINO, true);
    }
}
