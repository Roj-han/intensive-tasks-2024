package com.walking.intensive.chapter3.task12;

/**
 * Девочка Света очень любит играть в мячики. Она поставила в ряд корзинки и в некоторые положила по 1 мячику.
 * За 1 раз она может переложить 1 мячик в соседнюю корзинку. В 1 корзинке может поместиться много мячиков.
 *
 * <p>Необходимо помочь Свете. Реализуйте метод getMovementsNumber() с учетом условий ниже.
 *
 * <p>Входной параметр - строка, в которой закодировано положение мячиков в корзинках.
 *
 * <p>Например: "010" - всего есть три корзинки, мячик лежит только во второй.
 *
 * <p>Возвращаемое значение - массив, по размеру идентичный размеру входящей строки,
 * где arr[i] - минимальное количество операций, необходимых для перемещения всех мячиков в i-ю корзинку.
 *
 * <p> Количество необходимых операций для каждой из корзинок необходимо
 * вычислять исходя из начального расположения мячиков в корзинках.
 *
 * <p>Пример:
 *
 * <p>Входящая строка: "110"
 *
 * <p>Возвращаемое значение: [1,1,3]
 *
 * <p>Пояснение:
 *
 * <ul>
 * <li>Корзинка 1 (0-й индекс массива): требуется переложить 1 мячик из второй корзинки 1 раз.
 * <li>Корзинка 2 (1-й индекс массива): требуется переложить 1 мячик из первой корзинки во вторую 1 раз.
 * <li>Корзинка 3 (2-й индекс массива): требуется переложить 1 мячик из первой корзинки во вторую 1 раз,
 *      из второй корзинки переложить в третью 2 мячика по 1 разу, итого 3 раза.
 * </ul>
 *
 * <p>При наличии некорректных входных данных верните пустой массив.
 *
 * <p>P.S. Решение не должно использовать сортировки, коллекции, Stream API и иной материал, выходящий за рамки
 * пройденного курса.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task12 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        String str = "";
        System.out.println(Arrays.toString(getMovementsNumber(str)));
    }

    static int[] getMovementsNumber(String baskets) {
        if (baskets == null || baskets.isEmpty()) {
            return new int[]{};
        }

        int arrLength = baskets.length();
        int[] intArray = new int[arrLength];
        int i = 0;
        for (char ch : baskets.toCharArray()) {
            if (!(ch == '0' || ch == '1')) {
                return new int[]{};
            }
            if (ch == '0') {
                intArray[i] = 0;
            } else {
                intArray[i] = 1;
            }
            ++i;
        }

        int[] amountTransposition = new int[arrLength];
        for (int j = 0; j < arrLength; j++) {
            for (int k = 0; k < arrLength; k++) {
                if (intArray[k] == 1) {
                    amountTransposition[j] += getAbsNumber(j - k);
                }
            }
        }

        return amountTransposition;
    }

    static int getAbsNumber(int number) {
        if (number < 0) {
            return -number;
        }

        return number;
    }
}
