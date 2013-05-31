package br.fat.agendaeventos.teste;

import br.fat.agendaeventos.dao.*;
import br.fat.agendaeventos.modelo.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class TesteHibernate {
    public static void main(String[] args) {
        EventoDAO dao = new EventoDAO();

        List<Evento> eventos = dao.findAll();
        for (Evento evento : eventos) {
            JOptionPane.showMessageDialog(null, evento.getOQueE());
            StringBuilder sb = new StringBuilder();
            sb.append("Participantes:\n");
            Collection<EventoParticipante> ep = evento.getEventoParticipanteCollection();
            for (Iterator<EventoParticipante> it = ep.iterator(); it.hasNext();) {
                EventoParticipante eventoParticipante = it.next();
                sb.append(eventoParticipante.getContato().getNome());
                sb.append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
//        for (Contato contato : contatos) {
//            System.out.println(contato);
//            List<EventoParticipante> ep = (List<EventoParticipante>) contato.getEventoParticipanteCollection();
//            System.out.println("Eventos que o contato " + contato.getNome() + " esta inscrito");
//            for (EventoParticipante ev : ep) {
//                System.out.println(ev.getEvento().getOQueE());
//            }
//        }
        
//        JOptionPane.showMessageDialog(null, "Código gerado " + dao.getContato().getId());
    }
}
