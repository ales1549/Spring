package web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    //    Создайте еще один контроллер, замаппленный на /cars.
//    Создайте модель Car с тремя произвольными полями.
//    Создайте список из 5 машин.
//    Создайте сервис с методом, который будет возвращать указанное число машин из созданного списка.
//    Создайте страницу cars.html. Реализуйте создание таблицы с машинами из сервиса с помощью thymeleaf.
//    При запросе /cars выводить весь список. При запросе /cars?count=2 должен отобразиться список из 2 машин, при /cars?count=3 - из 3, и тд. При count ≥ 5 выводить весь список машин.
    // Метод, указывающий на класс конфигурации
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }


    // Добавление конфигурации, в которой инициализируем ViewResolver, для корректного отображения jsp.
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{web.config.WebConfig.class};
    }


    /* Данный метод указывает url, на котором будет базироваться приложение */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}