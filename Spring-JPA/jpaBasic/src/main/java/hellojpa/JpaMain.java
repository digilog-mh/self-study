package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //비영속
            /*Member member = new Member();
            member.setId(100L);
            member.setName("userA");*/

            //영속, 하지만 DB에 저장되는 것은 아님.
            //1차 캐쉬에 저장.
            /*Member member = em.find(Member.class, 1L);

            member.setName("userA");*/

            Member member = new Member();
            member.setUsername("A");
            System.out.println("===========");
            em.persist(member);
            System.out.println("===========");
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
