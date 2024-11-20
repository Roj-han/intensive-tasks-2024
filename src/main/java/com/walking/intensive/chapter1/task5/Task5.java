package com.walking.intensive.chapter1.task5;

import java.util.Arrays;

/**
 * Задача поиска площади, величин углов, длин высот, биссектрис, медиан, радиусов вписанной и описанной вокруг
 * треугольника окружностей является центральной в Геометрии.
 *
 * <p>Реализуйте представленные ниже методы в соответствии с заданными условиями.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task5 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
    }

    /**
     * Частным случаем Tеоремы Брахмагупты является формула Герона.
     *
     * <p>Реализуйте метод поиска площади треугольника формулой Герона.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - площадь треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */

    static boolean isIncorrectLengthsTriangle(double a, double b, double c) { //метод для проверки корректности вводимых данных

        if (a <= 0 || b <= 0 || c <= 0) {
            return true;
        }
        return !(a + b > c && a + c > b && b + c > a);
    }

    static double getAreaByHeron(double a, double b, double c) {
        if (isIncorrectLengthsTriangle(a, b, c))
            return -1;

        double halfOfPerimeter = (a + b + c) / 2;
        return Math.sqrt(halfOfPerimeter * (halfOfPerimeter - a) * (halfOfPerimeter - b) * (halfOfPerimeter - c));
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {
        double[] heights;

        if (isIncorrectLengthsTriangle(a, b, c)) {
            return heights = new double[0];
        }

        heights = new double[3];
        double squareOfTriangle = getAreaByHeron(a, b, c);
        heights[0] = 2 * squareOfTriangle / a;
        heights[1] = 2 * squareOfTriangle / b;
        heights[2] = 2 * squareOfTriangle / c;

        Arrays.sort(heights);
        return heights;
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        double[] medians;

        if (isIncorrectLengthsTriangle(a, b, c)) {
            return medians = new double[0];
        }

        medians = new double[3];
        medians[0] = Math.sqrt(2 * (b * b + c * c) - a * a) / 2;
        medians[1] = Math.sqrt(2 * (b * b + a * a) - c * c) / 2;
        medians[2] = Math.sqrt(2 * (a * a + c * c) - b * b) / 2;

        Arrays.sort(medians);
        return medians;
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        double[] bisectors;

        if (isIncorrectLengthsTriangle(a, b, c)) {
            return bisectors = new double[0];
        }

        bisectors = new double[3];
        bisectors[0] = Math.sqrt(a * b * (a + b + c) * (a + b - c)) / (a + b);
        bisectors[1] = Math.sqrt(a * c * (a + b + c) * (a + c - b)) / (a + c);
        bisectors[2] = Math.sqrt(c * b * (a + b + c) * (c + b - a)) / (c + b);

        Arrays.sort(bisectors);
        return bisectors;
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        double[] angles;

        if (isIncorrectLengthsTriangle(a, b, c)) {
            return angles = new double[0];
        }

        angles = new double[3];
        angles[0] = Math.acos((b * b + c * c - a * a) / (2 * b * c)) * 180 / Math.PI; //арккосинус значения косинуса угла и перевод из радиан в градусы
        angles[1] = Math.acos((a * a + c * c - b * b) / (2 * a * c)) * 180 / Math.PI;
        angles[2] = Math.acos((a * a + b * b - c * c) / (2 * a * b)) * 180 / Math.PI;

        Arrays.sort(angles);
        return angles;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        if (isIncorrectLengthsTriangle(a, b, c)) {
            return -1;
        }

        return 2 * getAreaByHeron(a, b, c) / (a + b + c); //по формуле площадь делится на полупериметр, поэтому 2 вынесено в числитель
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        if (isIncorrectLengthsTriangle(a, b, c)) {
            return -1;
        }

        return a * b * c / (4 * getAreaByHeron(a, b, c));
    }

    /**
     * Дополнительная задача по желанию.
     *
     * <p>Реализуйте метод, который будет возвращать площадь треугольника.
     *
     * <p>Расчет площади должен быть произведем через поиск косинуса угла через теорему косинусов,
     * далее нахождение синуса через основное тригонометрическое тождество
     * и подстановку синуса в нужную формулу для площади треугольника.
     * (Всего основных способов поиска площади треугольника 6)
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaAdvanced(double a, double b, double c) {

        return 0;
    }
}
