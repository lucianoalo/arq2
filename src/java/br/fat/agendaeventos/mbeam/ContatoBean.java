package br.fat.agendaeventos.mbeam;

import br.fat.agendaeventos.dao.ContatoDAO;
import br.fat.agendaeventos.modelo.Contato;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "contatoBean")
public class ContatoBean {
    private ContatoDAO contatoDAO;
    private Contato contato;
    
    public ContatoBean() {
        contato = new Contato();
        contatoDAO = new ContatoDAO();
    }
    
    public List<Contato> autoComplete(String filtro) {
        return contatoDAO.findByNome(filtro);
    }
    
    public List<Contato> getContatos() {
        return contatoDAO.findAll();
    }

    public ContatoDAO getContatoDAO() {
        return contatoDAO;
    }

    public void setContatoDAO(ContatoDAO contatoDAO) {
        this.contatoDAO = contatoDAO;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
    
    public String defineContatos() {
        return "addContatos";
    }
    
    public String gravar() {
        contatoDAO.setContato(contato);
        contatoDAO.inserir();
        System.out.println(contato);
        contato = new Contato();
        return "cadContato";
    }
    
    
    
}
