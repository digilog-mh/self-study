package hellojpa;

import lombok.*;

import javax.persistence.Embeddable;
import java.util.Objects;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String city;
    private String Street;
    private String zipcode;

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Address address = (Address) obj;
        return Objects.equals(city,address.city) &&
                Objects.equals(Street,address.Street) &&
                Objects.equals(zipcode,address.zipcode);
    }
}
