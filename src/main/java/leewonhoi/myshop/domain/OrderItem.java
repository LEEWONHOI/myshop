package leewonhoi.myshop.domain;

import leewonhoi.myshop.domain.item.Item;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice; // 주문 금액

    private int count;  // 주문 수량

    protected OrderItem() {}

    private OrderItem(Item item, int orderPrice, int count) {
        this.item = item;
        this.orderPrice = orderPrice;
        this.count = count;
    }

    // set Order
    public void addOrder(Order order) {
        this.order = order;
    }

    // == 생성 메서드 === //
    public static OrderItem createOrderItem(Item item, int orderPrice, int count) {
        item.removeStock(count);
        return new OrderItem(item, orderPrice, count);
    }


    // === 비즈니스 로직 === //
    /** 주문 취소 **/
    public void cancel() {
        // 재고 원상복구
        getItem().addStock(count);
    }

    // === 조회 로직 === //
    /** 주문 상품 가격 조회 **/
    public int orderItemTotalPrice() {
        // todo
//        return orderPrice * count;
        return getOrderPrice() * getCount();
    }

}
