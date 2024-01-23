package hellojpa;

import javax.persistence.*;


@Entity
@TableGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "MEMBER_SEQ", allocationSize = 50) //allocationSize > 미리 50개씩 DB에서 처리 후에, 캐쉬내에서 1씩 사용.
public class Member {
    //식별자 전략 > Long타입+대체키+키 생성전략 사용. *business 키를 기본키로 걸지 않도록 주의.

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "MEMBER_SEQ_GENERATOR")
    private Long id;

    @Column(name = "name", nullable = false)
    private String username;


    //JPA 특성상, 기본 생성자가 필요함.
    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
