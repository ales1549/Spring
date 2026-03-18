import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//Прочитайте про виды бинов.
//Создайте POJO-класс Cat.
//В классе AppConfig, по аналогии, создайте бин с именем “cat”.
//Настройте этот бин так, чтобы он создавался новым при каждом запросе.
//В классе App, по аналогии, вызовите еще раз бин HelloWorld, затем 2 раза вызовите бин cat. Сравните 2 пары бинов по ссылке и выведите результат в консоль. Для пары HelloWorld должно вернуться true, для cat - false. Так вы можете увидеть результат того, как работает наш контейнер.
//Раскомментируйте тестовый класс и проверьте своё решение.
public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld bean = (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(bean.getMessage());
        HelloWorld bean2 = (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(bean2.getMessage());
        Cat cat1 = (Cat) applicationContext.getBean("myaw");
        System.out.println(cat1.getVoice());
        Cat cat2 = (Cat) applicationContext.getBean("myaw");
        System.out.println(cat2.getVoice());
        System.out.println("bean == bean2: " + (bean == bean2));
        System.out.println("cat1 == cat2: " + (cat1 == cat2));

    }
}