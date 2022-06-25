package ru.vasyukov.custom.properties;

import org.aeonbits.owner.Config;

/**
 * Интерфейс для работы с проперти из файла application.properties и системными проперти
 * usage:  TestData.application.имяМетодаКлюча()
 * Описание в файле проперти
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:application.properties"
})
public interface Application extends Config {
    @Key("base.url.skillfactory")
    String baseUrlSkillfactory();

    @Key("end.catalog")
    String endCatalog();

    @Key("end.start.it")
    String endStartIt();

    @Key("end.data.scientist")
    String endDataScientist();

    @Key("end.data.science")
    String endDataScience();

    @Key("end.data.analyst.pro")
    String endDataAnalystPro();

    @Key("end.data.analytics")
    String endDataAnalytics();

    @Key("end.qa.python")
    String endQaPython();

    @Key("end.python.fullstack")
    String endPythonFullstack();

    @Key("end.web.developer")
    String endWebDeveloper();

    @Key("end.python.developer")
    String endPythonDeveloper();

    @Key("end.game.developer")
    String endGameDeveloper();

    @Key("end.game.developer.pro")
    String endGameDeveloperPro();

    @Key("end.qa.java")
    String endQaJava();

    @Key("end.java.developer")
    String endJavaDeveloper();

    @Key("end.qa.manual")
    String endQaManual();
}
