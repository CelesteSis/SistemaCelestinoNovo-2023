/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author u07540852100
 */
public abstract class DAO_Abstract {
    
    public Session session;
    
    public DAO_Abstract () {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory(); //criamo so obj session factory
        session = sessionFactory.openSession();//abri uma seção
    }
    
    public abstract void insert(Object object);
    public abstract void update(Object object);
    public abstract void delete(Object object);
    public abstract Object list(int id);
    public abstract List listALL();
    
   
}

