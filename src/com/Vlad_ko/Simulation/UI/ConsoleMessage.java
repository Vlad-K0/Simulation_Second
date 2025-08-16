package com.Vlad_ko.Simulation.UI;

public enum ConsoleMessage {
    START_MESSAGE("Программа Симуляция\n"),
    START_MENU("Выберите один из вариантов:\n" +
            "1. Сгенерировать карту\n" +
            "2. Настройки карты\n" +
            "3. Запустить симуляцию\n" +
            "4. Выйти из программы\n"),
    SETTINGS_MENU("Выберите один из вариантов:\n" +
            "1. Настроить размеры карты\n" +
            "2. Настроить максимальное количество сущностей\n" +
            "3. Выйти в главное меню\n"),
    WARING_GENERATE_DEFAULT_SETTINGS("Использовать стандартные размеры карты?(д\\н)\n"),
    WARING_START_DEFAULT_SETTINGS("Запустить симуляцию со стандартными настройками?(д\\н)\n"),
    WARING_END_FOOD_MENU("Упс, кажется пища для некоторых существ закончилась:\n" +
            "1. Добавить травоядных\n" +
            "2. Добавить еды для травоядных\n" +
            "3. Закончить симуляцию.\n"),
    SIMULATION_MODE_SELECT("Продолжить в бесконечном или пошаговом режиме(б\\п)\n"),
    RECREATE_MAP("Перегенерировать карту?(д\\н)"),
    WARING_WRONG_INPUT("Неверный ввод. Попробуйте ещё раз."),
    SETTINGS_MAP_SIZE("Укажите размеры окна:\n"),
    SETTINGS_MAP_WIDTH("Ширина:\n"),
    SETTINGS_MAP_HEIGHT("Высота:\n"),
    SETTINGS_MAX_ENTITY("Введите максимальное количество сущностей:\n"),
    SETTING_MAX_HERBIVORE("Травоядные: \n"),
    SETTING_MAX_OBSTACLE("Препятствия: \n"),
    SETTING_MAX_PREDATOR("Хищники: \n"),
    SETTING_MAX_EATABLE_ITEM("Съедобные предметы: \n"),
    SETTING_COUNT_TURN("Введите количество генерируемых ходов: \n"),
    ADD_EDIBLE_ITEMS("Добавить съедобных предметов?\n"),
    ADD_HERBIVORE("Добавить травоядных?\n"),
    HOW_MANY("Сколько?\n");


    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
