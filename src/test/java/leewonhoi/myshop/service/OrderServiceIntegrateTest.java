package leewonhoi.myshop.service;

import leewonhoi.myshop.domain.Address;
import leewonhoi.myshop.domain.Member;
import leewonhoi.myshop.domain.Order;
import leewonhoi.myshop.domain.OrderStatus;
import leewonhoi.myshop.domain.item.Book;
import leewonhoi.myshop.web.exception.NotEnoughStockException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class OrderServiceIntegrateTest {

    @PersistenceContext EntityManager em;
    @Autowired OrderService orderService;

    @Test
    void 상품주문() {
        // given
        Member member = createAndPersistMember("memberA", "123", new Address("a", "b", "c"));
        Book item = createAndPersistBook("itemA", 10000, 5);
        int orderCount = 2;

        // when
        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);
        Order findOrder = orderService.findById(orderId);

        // then
        assertThat(findOrder.getMember()).isEqualTo(member);
        assertThat(findOrder.getTotalPrice()).isEqualTo(20000);
        assertThat(item.getStockQuantity()).isEqualTo(3);

    }

    @Test
    void 상품주문_재고수량초과() {
        // given
        Member member = createAndPersistMember("memberA",  "123", new Address("a", "b", "c"));
        Book item = createAndPersistBook("itemA", 10000, 5);
        int orderCount = 10;

        // when && then
        assertThrows(NotEnoughStockException.class, () -> {
            orderService.order(member.getId(), item.getId(), orderCount);
        });
    }

    @Test
    void 주문취소() {
        // given
        Member member = createAndPersistMember("memberA", "123 ",new Address("a", "b", "c"));
        Book item = createAndPersistBook("itemA", 10000, 5);
        int orderCount = 3;

        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);
        assertThat(item.getStockQuantity()).isEqualTo(2);

        // when
        orderService.cancelOrder(orderId);

        Order canceledOrder = orderService.findById(orderId);

        // then
        assertThat(canceledOrder.getStatus()).isEqualTo(OrderStatus.CANCEL);
        assertThat(item.getStockQuantity()).isEqualTo(5);

    }



    private Book createAndPersistBook(String itemName, int price, int quantity) {
        Book item = new Book();
        item.initItem(itemName, price, quantity);
        item.initBook("hello", "12345");
        em.persist(item);
        return item;
    }

    private Member createAndPersistMember(String memberName,  String password, Address address) {
        Member member = new Member(memberName, password,  address);
        em.persist(member);
        return member;
    }
}