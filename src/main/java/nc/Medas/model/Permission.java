package nc.Medas.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Permission {
    private byte idPermission;
    private String action;

    @Id
    @Column(name = "id_permission")
    public byte getIdPermission() {
        return idPermission;
    }

    public void setIdPermission(byte idPermission) {
        this.idPermission = idPermission;
    }

    @Basic
    @Column(name = "action")
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permission that = (Permission) o;
        return idPermission == that.idPermission &&
                Objects.equals(action, that.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPermission, action);
    }
}
