package com.example.doubleinput;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MainTest {
    @Test
    void doublesInput() {
        assertEquals(7.0, Main.doubleValue(3.5));
    }
}