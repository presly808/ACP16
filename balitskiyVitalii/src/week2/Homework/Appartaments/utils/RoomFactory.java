package week2.Homework.Appartaments.utils;

import week2.Homework.Appartaments.model.Accessory;
import week2.Homework.Appartaments.model.District;
import week2.Homework.Appartaments.model.Room;

import java.util.HashSet;

/**
 * Created by vitalii on 02.02.17.
 */
public class RoomFactory {
    private static Long id = 0L;

    public static Room createRoom() {
        id++;
        return new Room(id, "Metalistov 15", 22, "good room", new HashSet<Accessory>(), District.SVYATOSHINO, true);
    }
}
