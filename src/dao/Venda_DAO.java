/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.RccVenda;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u07540852100
 */
public class Venda_DAO extends DAO_Abstract{

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
        Criteria criteria = session.createCriteria(RccVenda.class); //subistitui os comandos sql
        criteria.add(Restrictions.eq("rccIdVenda", id));// restringe a pesquisa ao objeto inform
        List lista = criteria.list();
        session.getTransaction().commit();
        return (Object) lista;
    }

    @Override
    public List listALL() {
        session.beginTransaction(); 
        Criteria criteria = session.createCriteria(RccVenda.class); //subistitui os comandos sql
        List lista = criteria.list();
        session.getTransaction().commit();
        return (ArrayList) lista;
    }
    
    public List listDataVenda(Date dataVenda) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RccVenda.class); 
        criteria.add(Restrictions.eq("rccDataVenda", dataVenda));
        List result = criteria.list();
        session.getTransaction().commit();
        return result;
    }
    
    public List listFkCliente(int fkCliente) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RccVenda.class); 
        criteria.add(Restrictions.eq("rccFkCliente", fkCliente));
        List result = criteria.list();
        session.getTransaction().commit();
        return result;
    }
    
    public List listFkVendedor(int fkVendedor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RccVenda.class); 
        criteria.add(Restrictions.eq("rccFkVendedor", fkVendedor));
        List result = criteria.list();
        session.getTransaction().commit();
        return result;
    }
    
    public List listDataFk(Date dataVenda, int fkCliente, int fkVendedor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RccVenda.class); 
        criteria.add(Restrictions.eq("rccDataVenda", dataVenda));
        criteria.add(Restrictions.eq("rccFkCliente", fkCliente));
        criteria.add(Restrictions.eq("rccFkVendedor", fkVendedor));
        List result = criteria.list();
        session.getTransaction().commit();
        return result;
    }
}
