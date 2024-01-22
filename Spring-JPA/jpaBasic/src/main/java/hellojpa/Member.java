package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {

    @Id
    private Long id;

    @Column(unique = true, length = 10)
    private String name;


    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    //JPA 특성상, 기본 생성자가 필요함.
    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
