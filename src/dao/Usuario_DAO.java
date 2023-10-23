/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.RccUsuario;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u07540852100
 */
public class Usuario_DAO extends DAO_Abstract{

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();//abre transação obrigatória do Hibernate
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Object list(int id) {
        session.beginTransaction(); 
        Criteria criteria = session.createCriteria(RccUsuario.class); //subistitui os comandos sql (select * from usuario)
        criteria.add(Restrictions.eq("rccIdUsuario", id));// restringe a pesquisa ao objeto informado (where rccIdUsuario = id)
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista.get(0); //(Object) lista
    }

    @Override
    public List listALL() {
        session.beginTransaction(); 
        Criteria criteria = session.createCriteria(RccUsuario.class); //subistitui os comandos sql
        List lista = criteria.list();
        session.getTransaction().commit();
        return (ArrayList) lista;
    }
    
    public List listNome(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RccUsuario.class); 
        criteria.add(Restrictions.ilike("rccNome", nome, MatchMode.ANYWHERE));
        List result = criteria.list();
        session.getTransaction().commit();
        return result;
    }
    
    public List listCpf(String cpf) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RccUsuario.class); 
        criteria.add(Restrictions.ilike("rccCpf", "%"+ cpf +"%"));
        List result = criteria.list();
        session.getTransaction().commit();
        return result;
    }
    
    public List listNomeCpf(String nome, String cpf) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RccUsuario.class); 
        criteria.add(Restrictions.ilike("rccNome", nome, MatchMode.ANYWHERE));
        criteria.add(Restrictions.ilike("rccCpf", "%"+ cpf +"%"));
        List result = criteria.list();
        session.getTransaction().commit();
        return result;
    }

    public Object ValidaLogin (String apelidoUser, String senhaUser) {
        session.beginTransaction(); 
        Criteria criteria = session.createCriteria(RccUsuario.class);
        criteria.add(Restrictions.eq("rccApelido", apelidoUser));
        
        Criteria criteria1 = session.createCriteria(RccUsuario.class); 
        criteria1.add(Restrictions.eq("rccSenha", senhaUser));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista.get(0); //(Object) lista
        
    }
    
}
