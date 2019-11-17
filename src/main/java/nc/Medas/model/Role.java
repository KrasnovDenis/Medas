package nc.Medas.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Role {
    private byte id;
    private String name;
    private byte idPermission;

    @Id
    @Column(name = "id")
    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "id_permission")
    public byte getIdPermission() {
        return idPermission;
    }

    public void setIdPermission(byte idPermission) {
        this.idPermission = idPermission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id &&
                idPermission == role.idPermission &&
                Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, idPermission);
    }
}
