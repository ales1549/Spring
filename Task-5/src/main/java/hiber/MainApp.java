package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;
//С работой ядра Спринг мы разобрались, теперь самое время подключить к нему пару модулей для комфортной работы.
//Начнем с ORM.
//Для работы с hibernate нам понадобится зависимость{{ hibernate-core}}, корректным взаимодействием со Спрингом озаботится зависимость spring-orm.
//Как вы можете видеть, зависимость spring-core пропала, это произошло из-за того, что она является транзитной для всех модулей Спринга и дублировать ее смысла нет.
//У нас появились пакеты model, service, теперь сервисы и DAO объявлены бинами с помощью аннотаций @Repository и @Service.
//В методе main будет происходить тестирование работоспособности нашего приложения. Класс Car аннотирован как стандартная сущность hibernate. В AppConfig теперь присутствует базовая настройка hibernate, берущая данные из файла db.properties. Обратите внимание, что для ее работы используется аннотация @PropertySource("classpath:db.properties"), обращающаяся к папке ресурсов.
//На этом настройка приложения окончена.
//Создайте соединение к своей базе данных и схему. Запустите приложение. Проверьте, что оно полностью работает.
//Создайте сущность Car с полями String model и int series, на которую будет ссылаться User с помощью связи one-to-one.
//Добавьте этот класс в настройки hibernate.
//Создайте несколько пользователей с машинами, добавьте их в базу данных, вытащите обратно.
//В сервис добавьте метод, который с помощью hql-запроса будет доставать юзера, владеющего машиной по ее модели и серии.
public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Иван", "Щекун", "schec88@mail.ru");
      Car car1 = new Car("Jaguar XF", 779);
      user1.setCar(car1);
      car1.setUser(user1);
      userService.addUserCar(user1, car1);
      User user2 = new User("Федор", "Емельяненко", "emelya777@mail.ru");
      Car car2 = new Car("Mercedes C63-AMG", 667);
      user2.setCar(car2);
      car2.setUser(user2);
      userService.addUserCar(user2, car2);
      User user3 = new User("Игорь", "Петушко", "petuh888@mail.ru");
      Car car3 = new Car("BMW 3", 888);
      user3.setCar(car3);
      car3.setUser(user3);
      userService.addUserCar(user3, car3);
      User user4 = new User("Максим", "Фифон","fifcha11@mail.ru");
      Car car4 = new Car("Audi A6", 434);
      user4.setCar(car4);
      car4.setUser(user4);
      userService.addUserCar(user4, car4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         Car car = user.getCar();
         if (car != null){
            System.out.println("Car = " + car.getModel() + " ,Series: " + car.getSeries());
         }else{System.out.println("None");}
         System.out.println();
      }
      User userByCar = userService.findUserByCar("Audi A6", 434);
      if (userByCar != null){
         System.out.println("Found user: " + userByCar.getFirstName());
      }else{
         System.out.println("None");
      }
      context.close();
   }
}
