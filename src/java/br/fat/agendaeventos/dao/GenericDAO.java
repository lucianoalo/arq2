package br.fat.agendaeventos.dao;

import br.fat.agendaeventos.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class GenericDAO {
    private Session session;
    private Transaction transaction;

    public abstract String inserir();
    public abstract String excluir();
    public abstract String atualizar();

    public GenericDAO() {
    }

    public void setSession(Session s) {
        this.session = s;
    }

    protected void initSession() {
        if (session == null) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
    }

    protected Session getSession() {
        return session;
    }

    protected void closeSession() {
        if (session != null) {
            try {
                session.close();
            } catch (HibernateException hex) {}

            session = null;
            transaction = null;
        }
    }

    protected void beginTransaction() {
        if (transaction == null) {
            transaction = getSession().beginTransaction();
        }
    }

    protected void commitTransaction() {
        transaction.commit();
    }

    protected void rollbackTransaction() {
        transaction.rollback();
    }

    @SuppressWarnings("unchecked")
    public Object insert(Object entity) {
        try {
            initSession();
            beginTransaction();
            getSession().save(entity);
            commitTransaction();
        } catch (Exception ex) {
            rollbackTransaction();
            throw new HibernateException("GenericDAO::insert " + ex.getMessage());
        } finally {
            closeSession();
        }

        return entity;
    }

    @SuppressWarnings("unchecked")
    public Object save(Object entity) {
        try {
            initSession();
            beginTransaction();
            getSession().merge(entity);
            commitTransaction();
        } catch (Exception ex) {
            rollbackTransaction();
            throw new HibernateException("GenericDAO::save " + ex.getMessage());
        } finally {
            closeSession();
        }

        return entity;
    }

    @SuppressWarnings("unchecked")
    public Object update(Object entity) {
        try {
            initSession();
            beginTransaction();
            entity = getSession().merge(entity);
            commitTransaction();
        } catch (Exception ex) {
            rollbackTransaction();
            throw new HibernateException("GenericDAO::update " + ex.getMessage());
        } finally {
            closeSession();
        }

        return entity;
    }

    public void delete(Object entity) {
        try {
            initSession();
            beginTransaction();
            clear();
            getSession().delete(entity);
            commitTransaction();
        } catch (Exception ex) {
            rollbackTransaction();
            throw new HibernateException("GenericDAO::delete " + ex.getMessage());
        } finally {
            closeSession();
        }
    }

    public void flush() {
        getSession().flush();
    }

    public void clear() {
        getSession().clear();
    }
}