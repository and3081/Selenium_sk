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
        return Stream.of(arguments("Все курсы обучения"));
    }

    protected static Stream<Arguments> providerSkill03() {
        return Stream.of(arguments("Надёжный старт в IT"));
    }

    protected static Stream<Arguments> providerSkill04() {
        return Stream.of(arguments("Data Scientist"));
    }

    protected static Stream<Arguments> providerSkill05() {
        return Stream.of(arguments("Полный курс по Data Science"));
    }

    protected static Stream<Arguments> providerSkill06() {
        return Stream.of(arguments("Аналитик Данных"));
    }

    protected static Stream<Arguments> providerSkill07() {
        return Stream.of(arguments("Полный курс по анализу данных"));
    }

    protected static Stream<Arguments> providerSkill08() {
        return Stream.of(arguments("Тестировщик\nна Python"));
    }

    protected static Stream<Arguments> providerSkill09() {
        return Stream.of(arguments("Fullstack-разработчик на Python"));
    }

    protected static Stream<Arguments> providerSkill10() {
        return Stream.of(arguments("Веб-разработчик с нуля"));
    }

    protected static Stream<Arguments> providerSkill11() {
        return Stream.of(arguments("Python-разработчик"));
    }

    protected static Stream<Arguments> providerSkill12() {
        return Stream.of(arguments("Разработчик игр на Unity"));
    }

    protected static Stream<Arguments> providerSkill13() {
        return Stream.of(arguments("Разработчик игр на Unity"));
    }

    protected static Stream<Arguments> providerSkill14() {
        return Stream.of(arguments("Тестировщик\nна Java"));
    }

    protected static Stream<Arguments> providerSkill15() {
        return Stream.of(arguments("Java-разработчик"));
    }

    protected static Stream<Arguments> providerSkill16() {
        return Stream.of(arguments("Инженер по ручному тестированию"));
    }

}
