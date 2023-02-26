package com.salomondev.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstantTest {

    @Test
    void testConstants() {
        assertThrows(IllegalStateException.class, Constant::new);
    }
}