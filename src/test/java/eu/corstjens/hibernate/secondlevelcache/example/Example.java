package eu.corstjens.hibernate.secondlevelcache.example;

import eu.corstjens.hibernate.secondlevelcache.example.model.Brand;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by koencorstjens on 16/04/16.
 */
public class Example {
    private EntityManagerFactory entityManagerFactory;

    @Before
    public void before() {
        entityManagerFactory = Persistence.createEntityManagerFactory("manager1");
    }

    @After
    public void afther() {
        entityManagerFactory.close();
    }

    @Test
    // to activate second level cache
    // set hibernate.cache.use_query_cache to true
    // set a second level cache provider for example hibernate.cache.region.factory_class org.hibernate.cache.ehcache.EhCacheRegionFactory
    // see persistence.xml
    // for ehcache add the ehcache.xml configuration file to the classpath
    public void getBrand() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Session session = (Session) entityManager.getDelegate();
        session.beginTransaction();
        Brand brand = session.get(Brand.class, 1l);
        session.getTransaction().commit();
        session.close();

        EntityManager entityManager2 = entityManagerFactory.createEntityManager();
        Session session2 = (Session) entityManager2.getDelegate();
        session2.beginTransaction();
        Brand brand2 = session2.get(Brand.class, 1l);
        session2.getTransaction().commit();
        session2.close();

    }


    //to activate query cache
    //set hibernate.cache.use_query_cache to true in the persistence.xml
    @Test
    public void getBrandByQuery() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Session session = (Session) entityManager.getDelegate();
        session.beginTransaction();
        Query query = session.createQuery("FROM Brand b WHERE b.id = 1l");
        //activate the cache for this query
        query.setCacheable(true);
        List list = query.list();
        session.getTransaction().commit();
        session.close();

        EntityManager entityManager2 = entityManagerFactory.createEntityManager();
        Session session2 = (Session) entityManager2.getDelegate();
        session2.beginTransaction();
        Query query2 = session2.createQuery("FROM Brand b WHERE b.id = 1l");
        //activate the cache for this query
        query2.setCacheable(true);
        List list2 = query2.list();
        session2.getTransaction().commit();
        session2.close();

    }


}
