package hellojpa;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Getter @Setter
@ToString
/*@TableGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "MEMBER_SEQ", allocationSize = 50)*/ //allocationSize > 미리 50개씩 DB에서 처리 후에, 캐쉬내에서 1씩 사용.
public class Member extends BaseEntity{
    //식별자 전략 > Long타입+대체키+키 생성전략 사용. *business 키를 기본키로 걸지 않도록 주의.
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    //값타입의 경우, 객체간의 참조값 복사를 막기 위해 Setter 메서드를 사용하지 않도록 막아둘 수 있다.(=불변 객체로 설계)
    @Embedded
    private Address homeAddress;

    @ElementCollection //지연로딩이 Defualt값.
    @CollectionTable(name="FAVORITE_FOOD", joinColumns = @JoinColumn(name = "MEMBER_ID"))
    private Set<String> favoriteFoods = new HashSet<>();

    @ElementCollection
    @CollectionTable(name="ADDRESS", joinColumns = @JoinColumn(name = "MEMBER_ID"))
    private List<Address> addressHistory = new ArrayList<>();


}
