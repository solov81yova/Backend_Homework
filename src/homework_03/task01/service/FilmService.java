package homework_03.task01.service;

import homework_03.task01.entity.Film;
import java.util.List;

public interface FilmService {

  public List<Film> findAll();

  public Film findById(Long id);

  public Film saveFilm(Film film);
}
