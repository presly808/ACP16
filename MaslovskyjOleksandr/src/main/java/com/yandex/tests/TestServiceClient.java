package com.yandex.tests;

import com.yandex.controllers.IServiceClient;
import com.yandex.exception.NoAvailableCarsException;
import com.yandex.exception.NoOrderFoundException;
import com.yandex.exception.NotValidPriceException;
import com.yandex.exception.WrongCoordinatesException;
import com.yandex.models.Location;
import com.yandex.models.Order;
import com.yandex.service.ServiceClient;
import com.yandex.service.ServiceLocation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class TestServiceClient {

    private Location currentLocation;
    private Location destination;
    private IServiceClient iServiceClient;

    @Before
    public void preparingData(){
        currentLocation = new Location(50.435, 30.317);
        destination = new Location(50.435, 30.359);
        iServiceClient = new ServiceClient();

    }

    @Test(expected = NoAvailableCarsException.class)
    public void testMakeOrderMethod() throws WrongCoordinatesException, NotValidPriceException, NoAvailableCarsException {
        Order actual = iServiceClient.makeOrder(currentLocation, destination);
    }

    @Test
    public void testShowTaxiList() throws NoAvailableCarsException {
        Assert.assertNull(iServiceClient.showTaxiList());
    }

    @Test
    public void testCancelOrder() throws NoOrderFoundException {
        Order order = mock(Order.class);
        Assert.assertTrue(iServiceClient.cancelOrder(order));
    }
}
