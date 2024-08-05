package homework_03.task01.repository;

import homework_03.task01.entity.Film;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class FilmRepositoryImpl implements FilmRepository {

  private static final Map<Long, Film> map = new HashMap<>();

  static {
    map.put(1L, new Film(1L, "The Shawshank Redemption", 1994, 142,
        "Drama", "Tim Robbins"));
    map.put(2L, new Film(2L, "The Godfather", 1972, 175,
        "Crime", "Marlon Brando"));
    map.put(3L, new Film(3L, "The Dark Knight", 2008, 152,
        "Action", "Christian Bale"));
    map.put(4L, new Film(4L, "Pulp Fiction", 1994, 154,
        "Crime", "John Travolta"));
    map.put(5L, new Film(5L, "The Lord of the Rings: The Return of the King",
        2003, 201, "Fantasy", "Elijah Wood"));
    map.put(6L, new Film(6L, "Forrest Gump", 1994, 142,
        "Drama", "Tom Hanks"));
    map.put(7L, new Film(7L, "Inception", 2010, 148,
        "Sci-Fi", "Leonardo DiCaprio"));
    map.put(8L, new Film(8L, "Fight Club", 1999, 139,
        "Drama", "Brad Pitt"));
    map.put(9L, new Film(9L, "The Matrix", 1999, 136,
        "Sci-Fi", "Keanu Reeves"));
    map.put(10L, new Film(10L, "Goodfellas", 1990, 146,
        "Crime", "Robert De Niro"));
  }

  @Override
  public List<Film> findAll() {
    return map.values().stream().toList();
  }

  @Override
  public Film saveFilm(Film film) {
    return null;
  }
}
