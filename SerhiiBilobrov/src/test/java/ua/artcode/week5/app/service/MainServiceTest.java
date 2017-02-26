package ua.artcode.week5.app.service;

import ua.artcode.week5.app.model.Region;

import static org.junit.Assert.*;

/**
 * Created by serhii on 26.02.17.
 */
public class MainServiceTest {

    private MainService mainService;

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void getCandidateByRegion() throws Exception {
        mainService.getCandidateByRegion(new Region());
    }

}