package jpql;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
public class MemberDTO {

    private String username;
    private int age;

    public MemberDTO(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
