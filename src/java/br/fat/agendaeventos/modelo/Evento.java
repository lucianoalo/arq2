package br.fat.agendaeventos.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "evento")
public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "o_que_e")
    private String oQueE;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dthr_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dthrInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dthr_fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dthrFim;
    @Size(max = 50)
    @Column(name = "onde")
    private String onde;
    @Size(max = 100)
    @Column(name = "detalhes")
    private String detalhes;
    @OneToMany(cascade = CascadeType.ALL, fetch = javax.persistence.FetchType.LAZY, mappedBy = "evento")
    private Collection<EventoParticipante> eventoParticipanteCollection;

    public Evento() {
    }

    public Evento(Integer id) {
        this.id = id;
    }

    public Evento(Integer id, String oQueE, Date dthrInicio, Date dthrFim) {
        this.id = id;
        this.oQueE = oQueE;
        this.dthrInicio = dthrInicio;
        this.dthrFim = dthrFim;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOQueE() {
        return oQueE;
    }

    public void setOQueE(String oQueE) {
        this.oQueE = oQueE;
    }

    public Date getDthrInicio() {
        return dthrInicio;
    }

    public void setDthrInicio(Date dthrInicio) {
        this.dthrInicio = dthrInicio;
    }

    public Date getDthrFim() {
        return dthrFim;
    }

    public void setDthrFim(Date dthrFim) {
        this.dthrFim = dthrFim;
    }

    public String getOnde() {
        return onde;
    }

    public void setOnde(String onde) {
        this.onde = onde;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public Collection<EventoParticipante> getEventoParticipanteCollection() {
        return eventoParticipanteCollection;
    }

    public void setEventoParticipanteCollection(Collection<EventoParticipante> eventoParticipanteCollection) {
        this.eventoParticipanteCollection = eventoParticipanteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.fat.agendaeventos.modelo.Evento[ id=" + id + " ]";
    }
    
}
