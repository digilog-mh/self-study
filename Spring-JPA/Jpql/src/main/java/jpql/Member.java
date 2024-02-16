package jpql;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Getter @Setter
@ToString

public class Member{

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private int age;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;


}
