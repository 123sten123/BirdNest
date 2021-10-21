package ru.birdnest.service;



import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;

public class MinIoServiceTest {

    MinIoService minIoService = new MinIoService();

    @Test
    public void test() throws IOException {
        minIoService.storeFile("11", new byte[]{1, -40});
        assertArrayEquals(new byte[]{1, -40}, minIoService.readFile("11"));
    }

}
