package hellojpa;

import lombok.*;

import javax.persistence.Embeddable;

@Getter @Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String city;
    private String Street;
    private String zipcode;

}
