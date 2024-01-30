package hellojpa;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter @Setter
@ToString
/*@TableGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "MEMBER_SEQ", allocationSize = 50)*/ //allocationSize > 미리 50개씩 DB에서 처리 후에, 캐쉬내에서 1씩 사용.
public class Member {
    //식별자 전략 > Long타입+대체키+키 생성전략 사용. *business 키를 기본키로 걸지 않도록 주의.
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID",insertable = false, updatable = false)
    private Team team;

    @OneToOne(mappedBy = "member")
   // @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();
}
