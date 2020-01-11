package nc.Medas.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Film {
    @NotNull
    private int id;
    @NotNull
    private short duration;
    @NotNull
    private String title;
    @NotNull
    private String poster;
    @NotNull
    private double rating;
    @NotNull
    private String director;
    @NotNull
    private String producer;
    @NotNull
    private int countReview;

    @Id
    @Column(name = "id")
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
                duration == film.duration &&
                Double.compare(film.rating, rating) == 0 &&
                countReview == film.countReview &&
                Objects.equals(title, film.title) &&
                Objects.equals(poster, film.poster) &&
                Objects.equals(director, film.director) &&
                Objects.equals(producer, film.producer);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, duration, title, rating, director, producer, countReview);
        result = 31 * result + Objects.hashCode(poster);
        return result;
    }
}
