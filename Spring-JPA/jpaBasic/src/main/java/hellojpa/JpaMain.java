package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;


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

            System.out.println("===========");
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);

            //역방향(주인이 아닌 방향)만 연관관계 설정
            //team.getMembers().add(member);
            // >> 메서드로 자동 추가.
            team.addMember(member);

            em.flush();
            em.clear();

            Team findTeam = em.find(Team.class, team.getId());
            List<Member> members = findTeam.getMembers();

            System.out.println("===========");

            for (Member m : members) {
                System.out.println("m.getUsername = " + m.getUsername());
            }

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
