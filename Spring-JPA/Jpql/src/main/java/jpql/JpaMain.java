package jpql;

import javax.persistence.*;
import java.util.List;


public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pratice");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            System.out.println("===========");

            Member member = new Member();
            member.setUsername("member1");
            em.persist(member);

            System.out.println("===========");

            TypedQuery<Member> query = em.createQuery(
                    "select m from Member m where m.username = :username"
                    , Member.class
            ).setParameter("username", "member1");

            System.out.println("member = " + query.getSingleResult());




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
