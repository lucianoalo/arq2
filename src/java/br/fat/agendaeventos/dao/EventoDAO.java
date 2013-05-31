package br.fat.agendaeventos.dao;

import br.fat.agendaeventos.modelo.Evento;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;

/**
 *
 * @author Bruno
 */
public class EventoDAO extends GenericDAO {
    
    private Evento evento;
    
    public EventoDAO() {
        evento = new Evento();
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
       
    public List<Evento> findAll() {
        List<Evento> eventos = new ArrayList<Evento>();
        initSession();
        
        Criteria c = getSession().createCriteria(Evento.class);
        eventos = c.list();
        
        closeSession();
        
        return eventos;
    }

    @Override
    public String inserir() {
        insert(evento);
        return "sucesso";
    }

    @Override
    public String excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String atualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
