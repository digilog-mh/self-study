package japbook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @JsonIgnore //API 요청시에, json 반환을 무시.
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

}
