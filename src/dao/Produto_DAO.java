/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.RccProduto;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u07540852100
 */
public class Produto_DAO extends DAO_Abstract{

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
        Criteria criteria = session.createCriteria(RccProduto.class); //subistitui os comandos sql
        criteria.add(Restrictions.eq("rccIdProduto", id));// restringe a pesquisa ao objeto inform
        List lista = criteria.list();
        session.getTransaction().commit();
        return (Object) lista;
    }

    @Override
    public List listALL() {
        session.beginTransaction(); 
        Criteria criteria = session.createCriteria(RccProduto.class); //subistitui os comandos sql
        List lista = criteria.list();
        session.getTransaction().commit();
        return (ArrayList) lista;
    }
    
    public List listNomeProduto(String nomeProduto) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RccProduto.class); 
        criteria.add(Restrictions.ilike("rccNomeProduto", nomeProduto, MatchMode.ANYWHERE));
        List result = criteria.list();
        session.getTransaction().commit();
        return result;
    }
    
    public List listPrecoMaior(Double preco) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RccProduto.class); 
        criteria.add(Restrictions.ge("rccPreco", preco));
        List result = criteria.list();
        session.getTransaction().commit();
        return result;
    }
    
    public List listPrecoMenor(Double preco) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RccProduto.class); 
        criteria.add(Restrictions.le("rccPreco", preco));
        List result = criteria.list();
        session.getTransaction().commit();
        return result;
    }
    
    public List listNomeProdutoPreco(String nomeProduto, Double precoMaior, Double precoMenor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RccProduto.class); 
        criteria.add(Restrictions.ilike("rccNomeProduto", nomeProduto, MatchMode.ANYWHERE));
        criteria.add(Restrictions.ge("rccPreco", precoMaior));
        criteria.add(Restrictions.le("rccPreco", precoMenor));
        List result = criteria.list();
        session.getTransaction().commit();
        return result;
    }
}
