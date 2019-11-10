package nc.Medas.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "film", schema = "medas")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Integer duration;
    private String title;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "duration")
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return id == film.id &&
                Objects.equals(duration, film.duration) &&
                Objects.equals(title, film.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, duration, title);
    }
}
