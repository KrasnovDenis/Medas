package nc.Medas.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Hall {
    private int id;
    private String title;
    private short capacity;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "capacity")
    public short getCapacity() {
        return capacity;
    }

    public void setCapacity(short capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hall hall = (Hall) o;
        return id == hall.id &&
                capacity == hall.capacity &&
                Objects.equals(title, hall.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, capacity);
    }
}
