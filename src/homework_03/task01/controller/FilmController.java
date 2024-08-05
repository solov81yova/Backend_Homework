package homework_03.task01.controller;

import homework_03.task01.entity.Film;
import homework_03.task01.service.FilmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FilmController {

  private final FilmService service;

  @Autowired
  public FilmController(FilmService service) {
    this.service = service;
  }

  public List<Film> getAllFilms() {
    return service.findAll();
  }

  public Film getFilmById(Long id) {
    return service.findById(id);
  }
}
