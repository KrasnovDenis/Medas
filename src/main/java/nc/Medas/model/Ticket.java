package nc.Medas.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Ticket {
    private int id;
    private User user;
    private Screen screen;
    private short chair;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @ManyToOne
    @JoinColumn(name = "id_user")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @ManyToOne
    @JoinColumn(name = "id_screen")
    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
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
                screen == ticket.screen &&
                user == ticket.user &&
                chair == ticket.chair;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, screen, user, chair);
    }
}
