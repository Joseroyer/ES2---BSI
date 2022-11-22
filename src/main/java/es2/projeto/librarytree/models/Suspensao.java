package es2.projeto.librarytree.models;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;


@Entity
@Table(name="suspensao")
public class Suspensao {
    private static final long serialVersionUID = 1L;

    @OneToMany
    @JoinColumn
    @Column(name="cliente_ra", nullable = false)
    private Cliente clientera;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idsus;

    @Column(name="emp_suspensao")
    private String empsus;

    @Column(name="dt_ini_susp")
    private String dtinisus;

    @Column(name="dt_fim_susp")
    private String dtfimsus;

    public Suspensao() {
    }

    public Suspensao(int clientera, long idsus, String empsus, String dtinisus, String dtfimsus) {
        this.clientera = clientera;
        this.idsus = idsus;
        this.empsus = empsus;
        this.dtinisus = dtinisus;
        this.dtfimsus = dtfimsus;
    }

    public int getClientera() {
        return clientera;
    }

    public void setClientera(int clientera) {
        this.clientera = clientera;
    }

    public long getIdsus() {
        return idsus;
    }

    public void setIdsus(long idsus) {
        this.idsus = idsus;
    }

    public String getEmpsus() {
        return empsus;
    }

    public void setEmpsus(String empsus) {
        this.empsus = empsus;
    }

    public String getDtinisus() {
        return dtinisus;
    }

    public void setDtinisus(String dtinisus) {
        this.dtinisus = dtinisus;
    }

    public String getDtfimsus() {
        return dtfimsus;
    }

    public void setDtfimsus(String dtfimsus) {
        this.dtfimsus = dtfimsus;
    }

    



    
}
