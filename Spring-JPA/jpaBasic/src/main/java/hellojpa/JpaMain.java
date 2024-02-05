package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            System.out.println("===========");

            Member member = new Member();
            member.setUsername("UserA");
            member.setAddress(new Address("City","street","152344"));
            member.setPeriod(new Period());

            System.out.println("===========");
            em.persist(member);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
