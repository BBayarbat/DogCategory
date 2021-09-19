package com.simple.main;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class DogManagerTests {
    @Test
    void testGetAll() {
        Map<String,List<String>> data = DogManager.getData();
        assertTrue(DogManager.getAll(data).size() > 0);
    }

    @Test
    void testGetData() {
        assertTrue(DogManager.getData().size() > 0);
    }
}
