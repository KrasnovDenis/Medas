package nc.Medas.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Comment {
    private int id;
    private BigInteger idUser;
    private int idFilm;
    private Timestamp date;
    private String text;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_user")
    public BigInteger getIdUser() {
        return idUser;
    }



    public void setIdUser(BigInteger idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "id_film")
    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id &&
                idUser == comment.idUser &&
                idFilm == comment.idFilm &&
                Objects.equals(date, comment.date) &&
                Objects.equals(text, comment.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUser, idFilm, date, text);
    }
}
