package com.yandex.tests;


import com.yandex.exception.NotValidPriceException;
import com.yandex.exception.WrongCoordinatesException;
import com.yandex.models.Location;
import com.yandex.service.ServiceLocation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class TestServiceLocation {

    private Location currentLocation;

    private Location destination;

    private ServiceLocation serviceLocation;

    @Before
    public void iniData(){
        currentLocation = mock(Location.class);
        destination = mock(Location.class);
        serviceLocation = new ServiceLocation();

        when(currentLocation.getX()).thenReturn(50.435);
        when(currentLocation.getY()).thenReturn(30.317);

        when(destination.getX()).thenReturn(50.435);
        when(destination.getY()).thenReturn(30.359);
    }

    @After
    public void clearData(){
        currentLocation = null;
        destination = null;
        serviceLocation = null;
    }

    @Test
    public void testCalculateDistanceMethod() throws WrongCoordinatesException {
        double distance = serviceLocation.calculateDistance(currentLocation, destination);
        System.out.println(distance);
        Assert.assertTrue( distance > 2900 && distance < 3100);
    }

    @Test
    public void testCalculatePriceMethod() throws NotValidPriceException, WrongCoordinatesException {
        double price = serviceLocation.calculatePrice(currentLocation, destination);
        Assert.assertTrue(price < 65 && price > 60);
    }
}
