package jpabasic.ex1hellojpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class Member {

    @Id
    private Long id;
    private String name;


}
