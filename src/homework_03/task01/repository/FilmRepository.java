package homework_03.task01.repository;

import homework_03.task01.entity.Film;
import java.util.List;

public interface FilmRepository {

  public List<Film> findAll();

  public Film saveFilm(Film film);
}
