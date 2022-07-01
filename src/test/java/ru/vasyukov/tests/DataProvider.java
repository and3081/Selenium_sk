package ru.vasyukov.tests;

import org.junit.jupiter.params.provider.Arguments;
import ru.vasyukov.custom.properties.TestData;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Класс провайдера данных для тестов
 */
@SuppressWarnings("unused")
public class DataProvider {
    protected static Stream<Arguments> providerSkill01() {
        return Stream.of(arguments(
                "Онлайн-школа SkillFactory — онлайн-обучение востребованным IT-профессиям",
                "+7 958 577-04-17",
                "+7 495 291-09-12",
                "info@skillfactory.ru"));
    }

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

    protected static Stream<Arguments> providerSkill17() {
        return Stream.of(arguments("123", "Укажите, пожалуйста, имя", "Please put a name"));
    }

    protected static Stream<Arguments> providerSkill18() {
        return Stream.of(arguments("123", "Укажите, пожалуйста, корректный email", "Please enter a valid email address"));
    }

    protected static Stream<Arguments> providerSkill19() {
        return Stream.of(arguments("111111111122", "Укажите, пожалуйста, корректный номер телефона", "Please put a correct phone number"));
    }

    protected static Stream<Arguments> providerSkill20() {
        return Stream.of(arguments("111", "Слишком короткое значение", "Value is too short"));
    }

    protected static Stream<Arguments> providerSkill21() {
        return Stream.of(arguments("Обязательное поле", "Required field"));
    }

    protected static Stream<Arguments> providerSkill22() {
        return Stream.of(arguments("Тестирование", "qa",
                List.of(TestData.application.baseUrlSkillfactory()+TestData.application.endQaPython(),
                        TestData.application.baseUrlSkillfactory()+TestData.application.endQaJava(),
                        TestData.application.baseUrlSkillfactory()+TestData.application.endQaManual())));
    }
}
