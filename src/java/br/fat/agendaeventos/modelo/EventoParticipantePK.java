package br.fat.agendaeventos.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Bruno
 */
@Embeddable
public class EventoParticipantePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_evento")
    private int idEvento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_contato")
    private int idContato;

    public EventoParticipantePK() {
    }

    public EventoParticipantePK(int idEvento, int idContato) {
        this.idEvento = idEvento;
        this.idContato = idContato;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdContato() {
        return idContato;
    }

    public void setIdContato(int idContato) {
        this.idContato = idContato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEvento;
        hash += (int) idContato;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventoParticipantePK)) {
            return false;
        }
        EventoParticipantePK other = (EventoParticipantePK) object;
        if (this.idEvento != other.idEvento) {
            return false;
        }
        if (this.idContato != other.idContato) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.fat.agendaeventos.modelo.EventoParticipantePK[ idEvento=" + idEvento + ", idContato=" + idContato + " ]";
    }
    
}
