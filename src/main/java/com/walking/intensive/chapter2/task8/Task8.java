package com.walking.intensive.chapter2.task8;

import java.util.Arrays;

/**
 * Добираясь в школу на трамвае Вова проверяет, является ли купленный билет счастливым.
 * Если является, то нужно загадать желание и съесть билетик.
 *
 * <p>Билет содержит 6 цифр, комбинации подбираются случайным образом от 000000 до 999999.
 *
 * <p>Билет считается счастливым, если сумма первых трех цифр равна сумме последних трех цифр.
 *
 * <p>Пример: 123411 – счастливый (1 + 2 + 3 == 4 + 1 + 1).
 *
 * <p>Реализуйте метод getHappyTicketChance(), который будет возвращать вероятность
 * выпадения счастливого билета.
 *
 * <p>P.S. Вероятность – это отношение благоприятных исходов к числу всех исходов.
 * Вероятность не может принимать значение больше 1.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task8 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        System.out.println(getHappyTicketChance());
    }

    static double getHappyTicketChance() {
        final int MAX_NUMBER = 1000;
        final int AMOUNT_SUMS = 28; //количество сумм трех цифр - от 0 до 27
        int happyTicketAmount = 0;
        int[] sumThreeNum = new int[MAX_NUMBER];

        for (int i = 0; i < MAX_NUMBER; i++) {          //заполняем массив суммами трех цифр
            sumThreeNum[i] = getSumThreeNumbers(i);
        }

        int[] amountEqualSum = new int[AMOUNT_SUMS];   //подсчитываем количество одинаковых сумм в половине билета
        for (int i = 0; i < MAX_NUMBER; i++) {
            ++amountEqualSum[sumThreeNum[i]];
        }

        for (int i = 0; i < AMOUNT_SUMS; i++) {
            happyTicketAmount += amountEqualSum[i] * amountEqualSum[i];
        }

        return (double) (happyTicketAmount) / 1000000;
    }

    static int getSumThreeNumbers(int num) {
        return num % 10 + (num / 10) % 10 + (num / 100) % 10;
    }

}
