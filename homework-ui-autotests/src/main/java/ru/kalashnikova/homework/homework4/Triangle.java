package ru.kalashnikova.homework.homework4;

import java.text.DecimalFormat;

public class Triangle {
    public static double calculateArea(double sadeA, double sadeB, double sadeC) {
        validate(sadeA, sadeB, sadeC);

        double area = 0;
        double s = (sadeA + sadeB + sadeC)/2;
        area = Math.sqrt(s*(s - sadeA)*(s - sadeB)*(s - sadeC));

        DecimalFormat df = new DecimalFormat("#.##");
        area = Double.parseDouble(df.format(area).replaceAll(",", "."));
        return area;
    }

    private static void validate(double sadeA, double sadeB, double sadeC){
        if (sadeA <= 0 || sadeB <= 0 || sadeC <= 0)
            throw new IllegalArgumentException("Сторона треугольника не может быть меньше или равной 0");

        if (sadeA + sadeB < sadeC || sadeB + sadeC < sadeA || sadeA + sadeC < sadeB)
            throw new IllegalArgumentException("Одна сторона треугольника больше суммы двух других сторон");
    }
}
