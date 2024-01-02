package japbook.jpashop.repository.order.simplequery;

import japbook.jpashop.domain.Address;
import japbook.jpashop.domain.Order;
import japbook.jpashop.domain.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderSimpleQueryDto {

    private Long orderId;
    private String name;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private Address address;

    /*public OrderSimpleQueryDto(Order order) {
        this.orderId = order.getId();
        this.name = order.getMember().getName(); //LAZY 초기화
        this.orderDate = order.getOrderDate();
        this.orderStatus = order.getStatus();
        this.address = order.getDelivery().getAddress(); //LAZY 초기화
    }*/

    public OrderSimpleQueryDto(Long orderId, String name, LocalDateTime orderDate, OrderStatus orderStatus, Address address) {
        this.orderId = orderId;
        this.name = name;  //LAZY 초기화
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.address = address;  //LAZY 초기화
    }
}
