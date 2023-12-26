package japbook.jpashop;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import japbook.jpashop.domain.*;
import japbook.jpashop.domain.item.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.dbInit1();
        initService.dbInit2();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{

        private final EntityManager em;
        
        public void dbInit1(){
            Member member = createMember("userA","서울","streetA","1111");
            em.persist(member);

            Book book1 = createBook("JPA1 book", 10000, 100);
            em.persist(book1);

            Book book2 = createBook("JPA2 book", 15000, 48);
            em.persist(book2);

            OrderItem orderItem1 = OrderItem.createOrderItem(book1, 10000, 1);
            OrderItem orderItem2 = OrderItem.createOrderItem(book2, 15000, 2);

            Delivery delivery = createDelivery(member);
            Order order = Order.createOrder(member, delivery, orderItem1, orderItem2);
            em.persist(order);
        }

        private Delivery createDelivery(Member member) {
            Delivery delivery = new Delivery();
            delivery.setAddress(member.getAddress());
            return delivery;
        }

        public void dbInit2(){
            Member member = createMember("userB","서울","streetB","2222");
            em.persist(member);

            Book book1 = createBook("SPRING1 book", 20000, 200);
            em.persist(book1);

            Book book2 = createBook("SPRING2 book", 40000, 300);
            em.persist(book2);

            OrderItem orderItem1 = OrderItem.createOrderItem(book1, 20000, 3);
            OrderItem orderItem2 = OrderItem.createOrderItem(book2, 40000, 4);

            Delivery delivery = createDelivery(member);
            Order order = Order.createOrder(member, delivery, orderItem1, orderItem2);
            em.persist(order);
        }

        private Book createBook(String book, int price, int stockQuantity) {
            Book book1 = new Book();
            book1.setName(book);
            book1.setPrice(price);
            book1.setStockQuantity(stockQuantity);
            return book1;
        }

        private Member createMember(String username, String city, String street, String zipcode) {
            Member member = new Member();
            member.setName(username);
            member.setAddress(new Address(city,street,zipcode));
            return member;
        }
    }
}


