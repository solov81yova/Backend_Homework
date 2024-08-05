package homework_03.task01;
/*
Выберете любую сущность, например Book. Создайте приложение по примеру того, что мы написали
на занятии. В вашем приложении должен быть слой домена (entity), слой репозитория (repository),
слой сервиса (service) и слой контроллера (controller).
Подключите Spring.
Реализуйте получение списка всех сущностей и получение сущности по id.
 */
import homework_03.task01.controller.FilmController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        ".homework_03.task01");
    FilmController controller = context.getBean(FilmController.class);
    System.out.println(controller.getAllFilms());
    System.out.println();
    System.out.println(controller.getFilmById(13L));
  }

}
