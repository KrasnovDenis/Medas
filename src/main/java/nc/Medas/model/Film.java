package nc.Medas.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Film {
    private int id;
    private short duration;
    private String title;
    private String poster;
    private double rating;
    private String director;
    private String producer;
    private int countReview;

    public Film( short duration, String title, double rating, String director, String producer, int countReview) {

        this.duration = duration;
        this.title = title;
        this.rating = rating;
        this.director = director;
        this.producer = producer;
        this.countReview = countReview;
    }

    public Film() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "duration")
    public short getDuration() {
        return duration;
    }

    public void setDuration(short duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "poster")
    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Basic
    @Column(name = "rating")
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "director")
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Basic
    @Column(name = "producer")
    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Basic
    @Column(name = "count_review")
    public int getCountReview() {
        return countReview;
    }

    public void setCountReview(int countReview) {
        this.countReview = countReview;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return id == film.id &&
                Double.compare(film.rating, rating) == 0 &&
                countReview == film.countReview &&
                Objects.equals(duration, film.duration) &&
                Objects.equals(title, film.title) &&
                Objects.equals(poster, film.poster) &&
                Objects.equals(director, film.director) &&
                Objects.equals(producer, film.producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, duration, title, poster, rating, director, producer, countReview);
    }
}
