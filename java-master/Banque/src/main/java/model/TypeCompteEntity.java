package model;

import javax.persistence.*;

@Entity
@Table(name = "Type_Compte", schema = "Java_Banque", catalog = "")
public class TypeCompteEntity {
    private int id;
    private String libelle;
    private double taux;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "libelle", nullable = false, length = 255)
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Basic
    @Column(name = "taux", nullable = false, precision = 0)
    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeCompteEntity that = (TypeCompteEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.taux, taux) != 0) return false;
        if (libelle != null ? !libelle.equals(that.libelle) : that.libelle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        temp = Double.doubleToLongBits(taux);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
