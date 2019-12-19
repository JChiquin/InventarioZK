import dao.HibernateDAO;
import dao.IHibernateDAO;
        import java.io.File;
        import java.util.List;
        import org.hibernate.SessionFactory;
        import org.hibernate.cfg.Configuration;
        import servicio.IServicio;
        import servicio.impl.Servicio;
        
            SessionFactory sessionFactory = new Configuration().configure(new File("hibernate.cfg.xml")).buildSessionFactory();
            IHibernateDAO hibernateDAO = new HibernateDAO();
            hibernateDAO.setSessionFactory(sessionFactory);
            IServicio servicio = new Servicio();
            servicio.setHibernateDAO(hibernateDAO);