package nc.Medas.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;
import java.util.Objects;

@Entity
public class Ticket {
    private int id;
    private int idScreen;
    private BigInteger idUser;
    private short chair;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_screen")
    public int getIdScreen() {
        return idScreen;
    }

    public void setIdScreen(int idScreen) {
        this.idScreen = idScreen;
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
    @Column(name = "chair")
    public short getChair() {
        return chair;
    }

    public void setChair(short chair) {
        this.chair = chair;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id &&
                idScreen == ticket.idScreen &&
                idUser == ticket.idUser &&
                chair == ticket.chair;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idScreen, idUser, chair);
    }
}
