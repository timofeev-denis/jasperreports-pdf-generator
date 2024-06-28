package ru.code4fun.demo.jasperreports;

import java.util.List;

public class DataGenerator {

    public static List<User> generate() {
        return List.of(
                new User("Журавлева Алёна Дмитриевна", "Россия, г. Майкоп, 3 Марта ул., д. 1 кв.181"),
                new User("Пименова Алиса Андреевна", "Россия, г. Ульяновск, Гагарина ул., д. 1 кв.19"),
                new User("Кузнецова Кристина Арсентьевна", "Россия, г. Ногинск, Молодежный пер., д. 8 кв.89"),
                new User("Логинова Вероника Ярославовна", "Россия, г. Петропавловск-Камчатский, Новоселов ул., д. 7 кв.150"));
    }
}