package japbook.jpashop.service;

import jakarta.persistence.EntityManager;
import japbook.jpashop.domain.item.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemUpdateTest {

    @Autowired
    EntityManager em;

    @Test
    public void upodateTest() throws Exception{
        Book book = em.find(Book.class, 1L);

        book.setName("test");

        //변경감지 == dirty checking

    }
}
