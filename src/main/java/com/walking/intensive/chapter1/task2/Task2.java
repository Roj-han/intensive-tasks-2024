package com.walking.intensive.chapter1.task2;

/**
 * Реализуйте метод getFlatLocation(), который будет принимать параметрами следующие данные:
 * <ul>
 * <li> Количество этажей в доме;
 * <li> Количество подъездов;
 * <li> Номер нужной квартиры.
 * </ul>
 *
 * <p>Необходимо определить подъезд, этаж и расположение нужной квартиры относительно лифта,
 * руководствуясь следующими правилами:
 * <ul>
 * <li> На этаже 4 квартиры;
 * <li> Нумерация квартир возрастает по часовой стрелке.
 * </ul>
 *
 * <p>Примеры строки, возвращаемой из метода:
 * <ul>
 * <li> 1 кв – 1 подъезд, 1 этаж, слева от лифта, влево
 * <li> 2 кв – 1 подъезд, 1 этаж, слева от лифта, вправо
 * <li> 3 кв – 1 подъезд, 1 этаж, справа от лифта, влево
 * <li> 4 кв – 1 подъезд, 1 этаж, справа от лифта, вправо
 * </ul>
 *
 * <p>Если для дома с указанной этажностью и количеством подъездов квартиры с заданным номером не существует,
 * метод должен вернуть строку "Такой квартиры не существует".
 *
 * <p>Если хотя бы один из указанных параметров некорректный - например, отрицательное число или 0,
 * метод должен вернуть строку "Некорректные входные данные".
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task2 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        System.out.println(getFlatLocation(2, 5, 12));
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {
        if (floorAmount <= 0 || entranceAmount <= 0 || flatNumber <= 0) {
            return "Некорректные входные данные";
        } else if (flatNumber > floorAmount * entranceAmount * 4) {
            return "Такой квартиры не существует";
        }

        int floor = 0, entrance = 0;
        int flatsInSection = floorAmount * 4; //количество квартир в подъезде

        if (flatNumber % flatsInSection == 0) {  // блок определения номера подъезда
            entrance = flatNumber / flatsInSection;
        } else {
            entrance = flatNumber / flatsInSection + 1;
        }

        if (entrance == 1) {                    // блок определения номера этажа
            if (flatNumber % 4 == 0) {
                floor = flatNumber / 4;
            } else {
                floor = flatNumber / 4 + 1;
            }
        } else {
            if (flatNumber % 4 == 0) {
                floor = (flatNumber - (entrance - 1) * flatsInSection) / 4;
            } else {
                floor = (flatNumber - (entrance - 1) * flatsInSection) / 4 + 1;
            }
        }

        String result = flatNumber + " кв - " + entrance + " подъезд, " + floor + " этаж, ";

        switch (flatNumber % 4) {
            case 1:
                result += "слева от лифта, влево";
                break;
            case 2:
                result += "слева от лифта, вправо";
                break;
            case 3:
                result += "справа от лифта, влево";
                break;
            case 0:
                result += "справа от лифта, вправо";
                break;
        }

        return result;
    }
}
