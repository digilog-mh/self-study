package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pratice");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            System.out.println("===========");

            System.out.println("===========");

            tx.commit();
            System.out.println("===========");
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
