package jpql;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "ORDERS")
public class Order {

    @Id @GeneratedValue
    private Long id;
    private int orderAmount;

    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
}
