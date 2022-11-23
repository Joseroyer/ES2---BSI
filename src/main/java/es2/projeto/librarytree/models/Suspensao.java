package es2.projeto.librarytree.models;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.crypto.Data;
import javax.persistence.*;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
// import es2.projeto.librarytree.models.Cliente;


@Entity
@Table(name="suspensao")
public class Suspensao {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idsus;

    @Column(name="emp_suspensao")
    private String empsus;

    @Column(name="sus_stt")
    private int Suspstt;

    @Column(name="cliente_ra")
    private String clientera;

    @Column(name="dt_ini_susp")
    private String dtinisus;

    @Column(name="dt_fim_susp")
    private String dtfimsus;


    public Suspensao() {
    }


    public Suspensao(long idsus, String empsus, int suspstt, String clientera, String dtinisus, String dtfimsus) {
        this.idsus = idsus;
        this.empsus = empsus;
        Suspstt = suspstt;
        this.clientera = clientera;
        this.dtinisus = dtinisus;
        this.dtfimsus = dtfimsus;
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


    public int getSuspstt() {
        return Suspstt;
    }


    public void setSuspstt(int suspstt) {
        Suspstt = suspstt;
    }


    public String getClientera() {
        return clientera;
    }


    public void setClientera(String clientera) {
        this.clientera = clientera;
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
