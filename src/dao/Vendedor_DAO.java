/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.RccVendedor;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u07540852100
 */
public class Vendedor_DAO extends DAO_Abstract{

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
        Criteria criteria = session.createCriteria(RccVendedor.class); //subistitui os comandos sql
        criteria.add(Restrictions.eq("rccIdVendedor", id));// restringe a pesquisa ao objeto inform
        List lista = criteria.list();
        session.getTransaction().commit();
        return (Object) lista;
    }

    @Override
    public List listALL() {
        session.beginTransaction(); 
        Criteria criteria = session.createCriteria(RccVendedor.class); //subistitui os comandos sql
        List lista = criteria.list();
        session.getTransaction().commit();
        return (ArrayList) lista;
    }
    
    public List listNome(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RccVendedor.class); 
        criteria.add(Restrictions.ilike("rccNome", nome, MatchMode.ANYWHERE));
        List result = criteria.list();
        session.getTransaction().commit();
        return result;
    }
    
    public List listSalarioMaior(Double salario) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RccVendedor.class); 
        criteria.add(Restrictions.ge("rccSalario", salario));
        List result = criteria.list();
        session.getTransaction().commit();
        return result;
    }
    
    public List listSalarioMenor(Double salario) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RccVendedor.class); 
        criteria.add(Restrictions.le("rccSalario", salario));
        List result = criteria.list();
        session.getTransaction().commit();
        return result;
    }
    
    public List listNomeSalario(String nome, Double salarioMaior, Double salarioMenor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RccVendedor.class); 
        criteria.add(Restrictions.ilike("rccNome", nome, MatchMode.ANYWHERE));
        criteria.add(Restrictions.ge("rccSalario", salarioMaior));
        criteria.add(Restrictions.le("rccSalario", salarioMenor));
        List result = criteria.list();
        session.getTransaction().commit();
        return result;
    }
    
}
