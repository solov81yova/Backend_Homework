package homework_03.task01.entity;

public class Film {

  private final Long id;
  private final String title;
  private final int releaseYear;
  private final int duration;
  private final String genre;
  private final String mainActor;

  public Film(Long id, String title, int releaseYear, int duration, String genre,
      String mainActor) {
    this.id = id;
    this.title = title;
    this.releaseYear = releaseYear;
    this.duration = duration;
    this.genre = genre;
    this.mainActor = mainActor;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public int getReleaseYear() {
    return releaseYear;
  }

  public int getDuration() {
    return duration;
  }

  public String getGenre() {
    return genre;
  }

  public String getMainActor() {
    return mainActor;
  }

  @Override
  public String toString() {
    return "Film{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", releaseYear=" + releaseYear +
        ", duration=" + duration +
        ", genre='" + genre + '\'' +
        ", mainActor='" + mainActor + '\'' +
        '}';
  }
}

