package ru.vasyukov.tests;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Класс провайдера данных для тестов
 */
@SuppressWarnings("unused")
public class DataProvider {
    /**
     * Метод-провайдер для тест-кейса testSkill01()
     * @return  стрим аргументов:
     */
    protected static Stream<Arguments> providerSkill01() {
        return Stream.of(arguments(
                "Онлайн-школа SkillFactory — онлайн-обучение востребованным IT-профессиям",
                "+7 958 577-04-17",
                "+7 495 291-09-12",
                "info@skillfactory.ru"));
    }

    /**
     * Метод-провайдер для тест-кейса testSkill02()
     * @return  стрим аргументов:
     */
    protected static Stream<Arguments> providerSkill02() {
        return Stream.of(arguments(
                "Онлайн-школа SkillFactory — онлайн-обучение востребованным IT-профессиям",
                "+7 958 577-04-17",
                "+7 495 291-09-12",
                "info@skillfactory.ru"));
    }

    /**
     * Метод-провайдер для тест-кейса testSberAstChoice()
     * @return  стрим аргументов: текст для поиска, больше цены, валюта,
     *                            фрагмент закона, макс.кол-во позиций просмотра, количество для выборки
     */
    protected static Stream<Arguments> providerSberAst() {
        return Stream.of(arguments("Страхование", 600000.0, "RUB", "44-ФЗ", 120, 10));
    }
}
