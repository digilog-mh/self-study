package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter @Setter
/*@TableGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "MEMBER_SEQ", allocationSize = 50)*/ //allocationSize > 미리 50개씩 DB에서 처리 후에, 캐쉬내에서 1씩 사용.
public class Member {
    //식별자 전략 > Long타입+대체키+키 생성전략 사용. *business 키를 기본키로 걸지 않도록 주의.

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    /*@Column(name = "TEAM_ID")
    private Long teamId;*/

    /*양방향 관계, 연관관계 주인은 Member. (외래키를 가지고 있는 쪽)*/
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TEAM_ID")
    private Team team;


    //JPA 특성상, 기본 생성자가 필요함.
    public Member() {
    }

}
