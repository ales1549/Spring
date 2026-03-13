package app;

import app.config.AppConfig;
import app.model.AnimalsCage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
//    Поработаем со связыванием бинов.
//    Вызывать бины из контекста хорошо, но не так удобно, как связывать их автоматически.
//    Для работы аннотаций связывания, я добавил в Maven ядро Cпринга, так мы имеем совершенно рабочее Spring-приложение, пусть и без дополнительных модулей.
//    В компоненте AnimalCage есть поле типа Animal, которое связано с помощью аннотации @Autowired. При выполнении программы DI-контейнер подтянет сюда бин, подходящий по типу.
//
//    Задание:
//
//    Создайте бин Dog, унаследуйте его от Animal. Создайте на основе этого класса компонент.
//    Запустите приложение и проверьте, что было выброшено исключение NoUniqueBeanDefinitionException. Это произошло из-за того, что существует 2 бина с типом Animal.
//    Прочитайте о связывании бинов по имени и свяжите AnimalCage c бином Dog через абстрактный класс Animal.
//    На основе класса Timer создайте бин. Свяжите с AnimalCage. Проверьте, что при выполнении метода main время, которое пишет таймер, одно и тоже.
//    Раскомментировать тест из заготовки и проверить своё решение.
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        long time = 0;
        for (int i = 0; i < 5; i++) {
            AnimalsCage bean =
                    applicationContext.getBean(AnimalsCage.class);
            bean.whatAnimalSay();
            if (i == 0){
                time = bean.getTimer().getTime();
                continue;
            }
        }
    }

}
