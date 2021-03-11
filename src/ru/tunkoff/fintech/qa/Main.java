package ru.tunkoff.fintech.qa;

import java.util.Scanner;

public class Main {

    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        Country country;
        String name;

        for (Country i : Country.values()) {
            System.out.println(i.toString());
        }

        System.out.println("\nВведите название страны:");
        while (true) {
            if (input.hasNextLine()) {
                name = input.nextLine().trim();
                if (name.isEmpty()) {
                    System.out.println("Не введено название страны.");
                    return;
                }
                try {
                    country = Country.valueOf(name.toUpperCase().replace(" ", "_"));
                    break;
                } catch (NullPointerException e) {
                    System.out.println("Не введено название страны или список стран пуст.");
                    return;
                } catch (IllegalArgumentException e) {
                    System.out.println("Наименование страны на английском введено некорректно, "
                            + "проверяем русское название...");
                }
                try {
                    country = Country.getByRuName(name);
                    break;
                } catch (NoSuchCountryException e) {
                    System.out.println("Страны '" + name + "' не существует.");
                    return;
                }
            }
        }
        if (country.isOpen()) {
            System.out.println("Страна [" + country + "] открыта для посещения.");
        } else {
            System.out.println("Страна [" + country + "] закрыта для посещения.");
        }
    }
}
