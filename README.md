# coffee
Для того что бы развернуть проект на Tomcat, необходимо:
1. Создать переменную окружения CATALINA_HOME
2. Скопировать конфигурационные файлы db.properties и config.properties в каталог ${CATALINA_HOME}/coffee/
3. Cобрать проект командой mvn install
4. Скопировать полученный файл coffee.war в каталог {CATALINA_HOME}/coffee/webapps/
5. Запустить Tomcat командой catalina run