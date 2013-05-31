package br.fat.agendaeventos.dao;

import br.fat.agendaeventos.modelo.Contato;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Bruno
 */
public class ContatoDAO extends GenericDAO {
    
    private Contato contato;
    
    public ContatoDAO() {
        contato = new Contato();
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
    
    public List<Contato> findByNome(String nome) {
        List<Contato> contatos;
        initSession();
        
        Criteria c = getSession().createCriteria(Contato.class)
                        .add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
                        .addOrder(Order.asc("nome"));
        contatos = c.list();
        
        closeSession();
        
        return contatos;
    }    
    
    public List<Contato> findAll() {
        List<Contato> contatos = new ArrayList<Contato>();
        initSession();
        
        Criteria c = getSession().createCriteria(Contato.class)
                        .addOrder(Order.asc("nome"));
        contatos = c.list();
        
        closeSession();
        
        return contatos;
    }

    @Override
    public String inserir() {
        insert(contato);
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
