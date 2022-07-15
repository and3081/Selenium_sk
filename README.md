#### Тестирование сайта https://skillfactory.ru 
* Selenium
* Java 17 / Maven
* Junit5
* Allure 

## запуск всех тестов
mvn clean test

## построение отчета Allure
mvn allure:serve

## настройки в классе DataProvider
параметризация тестов

## настройки в проперти:
* application.properties - настройки url и endpoints сайта<br>
* browser.properties - настройки браузеров и веб-драйвера (описание в файле)<br>
* listener.properties - настройки автоматического листенера скриншотов для Allure (описание в файле)

# тест-кейсы:
### Тестирование информации в футере и title главной страницы
1. Тестирование title, телефонов, email
### Тестирование клика плашек блока 'Популярные курсы' главной страницы<br>и заголовков h1 соответствующих страниц
2. Тестирование /catalogue<br>Все курсы обучения
3. Тестирование /start-it-specialist-proforientaciya<br>Надёжный старт в IT
4. Тестирование /data-scientist-pro<br>Data Scientist
5. Тестирование /data-science-specialization<br>Полный курс по Data Science
6. Тестирование /data-analyst-pro<br>Аналитик Данных
7. Тестирование /data-analytics<br>Полный курс по анализу данных
8. Тестирование /qa-engineer-python-testirovshchik-programmnogo-obespecheniya<br>Тестировщик на Python
9. Тестирование /python-fullstack-web-developer<br>Fullstack-разработчик на Python
10. Тестирование /web-developer<br>Веб-разработчик с нуля
11. Тестирование /python-developer<br>Python-разработчик
12. Тестирование /game-razrabotchik-na-unity-i-c-sharp<br>Разработчик игр на Unity
13. Тестирование /game-developer-pro<br>Разработчик игр на Unity
14. Тестирование /java-qa-engineer-testirovshik-po<br>Тестировщик на Java
15. Тестирование /java-razrabotchik<br>Java-разработчик
16. Тестирование /qa-engineer-po-ruchnomu-testirovaniyu<br>Инженер по ручному тестированию
### Негативные проверки для полей ввода в блоке 'Получите консультацию' на главной странице с кликом кнопки 'Получить консультацию'
17. Тестирование ввода неправильного имени '123'<br>Укажите, пожалуйста, имя
18. Тестирование ввода неправильного email '123'<br>Укажите, пожалуйста, корректный email
19. Тестирование ввода неправильного телефона '111111111122'<br>Укажите, пожалуйста, корректный номер телефона
20. Тестирование ввода короткого телефона '111'<br>Слишком короткое значение
21. Тестирование пустого ввода<br>Обязательное поле
### Тестирование выборки в /catalogue
22. Кнопка 'Все курсы' на главной странице<br>
    * кнопка 'Показать все' в Направление<br>
    * пункт 'Тестирование'<br>
    * проверка наличия в результатах трех ссылок qa:<br>
      * /qa-engineer-python-testirovshchik-programmnogo-obespecheniya<br>
      * /java-qa-engineer-testirovshik-po<br>
      * /qa-engineer-po-ruchnomu-testirovaniyu
