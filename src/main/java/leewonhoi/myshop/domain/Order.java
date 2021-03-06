package leewonhoi.myshop.domain;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();


    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    // === 연관관계 편의 메서드 === //
    public void addMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    public void addDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.addOrder(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.addOrder(this);
    }

    public void addOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void addOrderStatus(OrderStatus status) {
        this.status = status;
    }


    // === 생성 메서드 === //
    public static Order createOrder(Member member, Delivery delivery, OrderItem... orderItems) {
        Order order = new Order();
        order.addMember(member);
        order.addDelivery(delivery);

        for (OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
        }
        order.addOrderStatus(OrderStatus.ORDER);
        order.addOrderDate(LocalDateTime.now());

        return order;
    }

    // === 비즈니스 로직 === //
    /** 주문 취소 **/
    public void cancel() {
        if (delivery.getStatus() == DeliveryStatus.COMP) {
            throw new IllegalStateException("이미 배송완료된 상품은 취소가 불가능합니다.");
        }

        this.addOrderStatus(OrderStatus.CANCEL);
        for (OrderItem orderItem : orderItems) {
            orderItem.cancel();
        }
    }

    // === 조회 로직 === //
    /** 전체 주문 가격 조회 **/
    public int getTotalPrice() {
        int total = 0;
        for (OrderItem orderItem : orderItems) {
            total += orderItem.orderItemTotalPrice();
        }
        return total;
    }


}
