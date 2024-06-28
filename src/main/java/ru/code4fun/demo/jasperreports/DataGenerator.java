package ru.code4fun.demo.jasperreports;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {
    public static List<User> generate() {
        List<User> users = new ArrayList<>();

        users.add(new User("Журавлева Алёна Дмитриевна", "Россия, г. Майкоп, 3 Марта ул., д. 1 кв.181"));
        users.add(new User("Пименова Алиса Андреевна", "Россия, г. Ульяновск, Гагарина ул., д. 1 кв.19"));
        users.add(new User("Кузнецова Кристина Арсентьевна", "Россия, г. Ногинск, Молодежный пер., д. 8 кв.89"));
        users.add(new User("Логинова Вероника Ярославовна", "Россия, г. Петропавловск-Камчатский, Новоселов ул., д. 7 кв.150"));

        return users;
    }
}
