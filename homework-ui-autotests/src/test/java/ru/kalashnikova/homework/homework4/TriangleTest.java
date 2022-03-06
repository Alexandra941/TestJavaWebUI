package ru.kalashnikova.homework.homework4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {
    @Test
    public void testCalculateArea() {
        double expectedArea = 36.98;
        double calculateResult = Triangle.calculateArea(8, 10, 15);
        assertEquals(expectedArea, calculateResult, 0);
    }

    @Test
    public void testCalculateAreaExceptionSideLessZero() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            Triangle.calculateArea(8, 10, -15);
        });

        assertEquals("Сторона треугольника не может быть меньше или равной 0", ex.getMessage());
    }

    @Test
    public void testCalculateAreaExceptionLargeSide() {

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            Triangle.calculateArea(8, 10, 19);
        });

        assertEquals("Одна сторона треугольника больше суммы двух других сторон", ex.getMessage());
    }
}