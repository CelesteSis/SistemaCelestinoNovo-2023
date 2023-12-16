/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.RccVenda;
import bean.RccVendaProduto;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u07540852100
 */
public class Venda_produto_DAO extends DAO_Abstract{
    
    public List listaPedido(RccVenda venda) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RccVendaProduto.class); 
        criteria.add(Restrictions.eq("rcc_venda", venda)); //aqui pode dar erro devido ao nome da tabela no bd
        List result = criteria.list();
        session.getTransaction().commit();
        return result;
    }

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
        Criteria criteria = session.createCriteria(RccVendaProduto.class); //subistitui os comandos sql
        criteria.add(Restrictions.eq("rccIdVendaProduto", id));// restringe a pesquisa ao objeto inform
        List lista = criteria.list();
        session.getTransaction().commit();
        return (Object) lista;
    }

    @Override
    public List listALL() {
        session.beginTransaction(); 
        Criteria criteria = session.createCriteria(RccVendaProduto.class); //subistitui os comandos sql
        List lista = criteria.list();
        session.getTransaction().commit();
        return (ArrayList) lista;
    }
    
}
