package br.fat.agendaeventos.mbeam;

import br.fat.agendaeventos.dao.EventoDAO;
import br.fat.agendaeventos.modelo.Evento;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "eventoBean")
public class EventoBean {
    private EventoDAO eventoDAO;
    private Evento evento;
    
    public EventoBean() {
        evento = new Evento();
        eventoDAO = new EventoDAO();
    }
        
    public List<Evento> getEventos() {
        return eventoDAO.findAll();
    }

    public EventoDAO getEventoDAO() {
        return eventoDAO;
    }

    public void setEventoDAO(EventoDAO eventoDAO) {
        this.eventoDAO = eventoDAO;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    public String gravar() {
        eventoDAO.setEvento(evento);
        eventoDAO.inserir();
        
        FacesMessage msg = new FacesMessage("Evento cadastrado com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
        evento = new Evento();
        return "cadEvento";
    }
    
    
    
}
