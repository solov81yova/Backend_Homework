package homework_03.task01.service;

import homework_03.task01.entity.Film;
import homework_03.task01.repository.FilmRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FilmServiceImpl implements FilmService {

  private final FilmRepository filmRepository;

  @Autowired
  public FilmServiceImpl(FilmRepository filmRepository) {
    this.filmRepository = filmRepository;
  }

  @Override
  public List<Film> findAll() {

    return filmRepository.findAll();
  }

  @Override
  public Film findById(Long id) {
    return filmRepository.findAll().stream()
        .filter(film -> film.getId().equals(id))
        .findFirst()
        .orElse(null);
  }

  @Override
  public Film saveFilm(Film film) {
    return filmRepository.saveFilm(film);
  }
}
