package jpql;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;


public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pratice");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            System.out.println("===========");

            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member m = new Member();
            m.setUsername("관리자");
            m.setAge(35);
            m.setType(MemberType.ADMIN);

            m.setTeam(team);

            em.persist(m);

            System.out.println("===========");

            em.flush();
            em.clear();

            List<String> list = em.createQuery(
                    "select nullif(m.username, '관리자') as username " +
                            "from Member m "
            ).getResultList();

            for (String s : list) {
                System.out.println("s = " + s);
            }

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
