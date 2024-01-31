package hellojpa;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@ToString
public class Team extends BaseEntity{

    @Id @GeneratedValue
    private Long id;

    private String name;

    //읽기만 가능하기에, 테이블에 영향을 주지 않음.
    @OneToMany
    @JoinColumn(name = "MEMBER_ID")
    private List<Member> members = new ArrayList<>();

    public Team() {
    }
}
