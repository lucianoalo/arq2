package br.fat.agendaeventos.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "evento_participante")
@NamedQueries({
    @NamedQuery(name = "EventoParticipante.findAll", query = "SELECT e FROM EventoParticipante e"),
    @NamedQuery(name = "EventoParticipante.findByIdEvento", query = "SELECT e FROM EventoParticipante e WHERE e.eventoParticipantePK.idEvento = :idEvento"),
    @NamedQuery(name = "EventoParticipante.findByIdContato", query = "SELECT e FROM EventoParticipante e WHERE e.eventoParticipantePK.idContato = :idContato"),
    @NamedQuery(name = "EventoParticipante.findByConfirmado", query = "SELECT e FROM EventoParticipante e WHERE e.confirmado = :confirmado")})
public class EventoParticipante implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EventoParticipantePK eventoParticipantePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "confirmado")
    private String confirmado;
    
    @JoinColumn(name = "id_evento", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(fetch = javax.persistence.FetchType.EAGER, optional = false)
    private Evento evento;
    @JoinColumn(name = "id_contato", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(fetch = javax.persistence.FetchType.EAGER, optional = false)
    private Contato contato;

    public EventoParticipante() {
    }

    public EventoParticipante(EventoParticipantePK eventoParticipantePK) {
        this.eventoParticipantePK = eventoParticipantePK;
    }

    public EventoParticipante(EventoParticipantePK eventoParticipantePK, String confirmado) {
        this.eventoParticipantePK = eventoParticipantePK;
        this.confirmado = confirmado;
    }

    public EventoParticipante(int idEvento, int idContato) {
        this.eventoParticipantePK = new EventoParticipantePK(idEvento, idContato);
    }

    public EventoParticipantePK getEventoParticipantePK() {
        return eventoParticipantePK;
    }

    public void setEventoParticipantePK(EventoParticipantePK eventoParticipantePK) {
        this.eventoParticipantePK = eventoParticipantePK;
    }

    public String getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(String confirmado) {
        this.confirmado = confirmado;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventoParticipantePK != null ? eventoParticipantePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventoParticipante)) {
            return false;
        }
        EventoParticipante other = (EventoParticipante) object;
        if ((this.eventoParticipantePK == null && other.eventoParticipantePK != null) || (this.eventoParticipantePK != null && !this.eventoParticipantePK.equals(other.eventoParticipantePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.fat.agendaeventos.modelo.EventoParticipante[ eventoParticipantePK=" + eventoParticipantePK + " ]";
    }
    
}
