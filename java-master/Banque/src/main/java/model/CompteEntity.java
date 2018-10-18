package model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Compte", schema = "Java_Banque", catalog = "")
public class CompteEntity {
    private int id;
    private double solde;
    private Date dateCreation;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "solde", nullable = false, precision = 0)
    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    @Basic
    @Column(name = "date_creation", nullable = false)
    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompteEntity that = (CompteEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.solde, solde) != 0) return false;
        if (dateCreation != null ? !dateCreation.equals(that.dateCreation) : that.dateCreation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(solde);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (dateCreation != null ? dateCreation.hashCode() : 0);
        return result;
    }
}
