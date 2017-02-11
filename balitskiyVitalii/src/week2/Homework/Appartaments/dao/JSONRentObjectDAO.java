package week2.Homework.Appartaments.dao;

import week2.Homework.Appartaments.model.AppartamentsStorage;
import week2.Homework.Appartaments.model.Flat;
import week2.Homework.Appartaments.model.House;
import week2.Homework.Appartaments.model.Room;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by vitalii on 01.02.17.
 */
public class JSONRentObjectDAO implements RentObjectDAO {

    public static final String APPARTAMENTS_STORAGE = "AppartamentsStorage";
    private AppartamentsStorage storage;
    private Gson parser;
    private Writer writer;
    private BufferedReader reader;

    public JSONRentObjectDAO(AppartamentsStorage storage) {
        this.storage = storage;
        parser = new GsonBuilder().create();
        try {
            writer = new OutputStreamWriter(new FileOutputStream(APPARTAMENTS_STORAGE + ".json"), "UTF-8");
            reader = new BufferedReader(new FileReader(APPARTAMENTS_STORAGE + "1.json"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<Long, Flat> getFlats(int offset) {

        Type responseType = new TypeToken<List<Flat>>(){}.getType();

        List<Flat> listItemsDes = parser.fromJson(reader, responseType);

        Map<Long, Flat> resultFlats =  listItemsDes.stream().collect(Collectors.toMap(x -> x.getId(), x -> x));
        return resultFlats;
    }

    @Override
    public Map<Long, Room> getRooms(int offset) {
        return null;
    }

    @Override
    public Map<Long, House> getHouses(int offset) {
        return null;
    }

    @Override
    public List<Flat> addFlats(List<Flat> flats) {
        Map<Long, Flat> resultFlats = new HashMap<>();

        parser.toJson(flats, writer);

        try {
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return flats;
    }

    @Override
    public List<Room> addRooms(List<Room> rooms) {
        return null;
    }

    @Override
    public List<House> addHouses(List<House> houses) {
        return null;
    }
}
