package week2.Homework.Appartaments.test;

import week2.Homework.Appartaments.exceptions.NoSuchRentObjectException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by vitalii on 02.02.17.
 */
public class RentObjectServiceTest extends InitMocksContext {

    @Test
    public void getFlatsTest(){
        try {
            assertThat(flatList, is(rentObjectService.getFlats()));
        } catch (NoSuchRentObjectException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getHousesTest(){
        try {
            assertThat(houseList, is(rentObjectService.getHouses()));
        } catch (NoSuchRentObjectException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getRoomsTest(){
        try {
            assertThat(roomList, is(rentObjectService.getRooms()));
        } catch (NoSuchRentObjectException e) {
            e.printStackTrace();
        }
    }

}
