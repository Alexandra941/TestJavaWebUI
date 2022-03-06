package ru.kalashnikova.homework.homework4;

import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class TriangleTest {
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testCalculateArea() {
        double expectedArea = 36.98;
        double calculateResult = Triangle.calculateArea(8, 10, 15);
        assertEquals(expectedArea, calculateResult, 0);
    }

    @Test
    public void testCalculateAreaExceptionSideLessZero() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Сторона треугольника не может быть меньше или равной 0");

        Triangle.calculateArea(8, 10, -15);
    }

    @Test
    public void testCalculateAreaExceptionLargeSide() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Одна сторона треугольника больше суммы двух других сторон");
        Triangle.calculateArea(8, 10, 19);
    }
}