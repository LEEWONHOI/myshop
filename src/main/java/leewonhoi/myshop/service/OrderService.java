package leewonhoi.myshop.service;

import leewonhoi.myshop.domain.*;
import leewonhoi.myshop.domain.item.Item;
import leewonhoi.myshop.web.exception.NotFoundItem;
import leewonhoi.myshop.web.exception.NotFoundMember;
import leewonhoi.myshop.web.exception.NotFoundOrder;
import leewonhoi.myshop.repository.ItemRepository;
import leewonhoi.myshop.repository.MemberRepository;
import leewonhoi.myshop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    /** 주문 생성 **/
    @Transactional
    public Long order(Long memberId, Long itemId, int count) {
        // 엔티티 조회
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new NotFoundMember("회원을 찾을 수 없습니다."));
        Item item = itemRepository.findItem(itemId).orElseThrow(() -> new NotFoundItem("아이템을 찾을 수 없습니다."));

        // 배송지 정보 생성
        Delivery delivery = new Delivery(member.getAddress(), DeliveryStatus.READY);

        // 주문 상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        // 주문 생성
        Order order = Order.createOrder(member, delivery, orderItem);

        orderRepository.save(order);
        return order.getId();
    }

    /** 주문 취소 **/
    @Transactional
    public void cancelOrder(Long orderId) {
        // 주문 엔티티 조회
        Order order = orderRepository.findOne(orderId).orElseThrow(() -> new NotFoundOrder("주문을 찾을 수 없습니다."));
        order.cancel();
    }

    /** 주문 조회 **/
    public Order findById(Long orderId) {
        return orderRepository.findOne(orderId).orElseThrow(() -> new NotFoundOrder("주문을 찾을 수 없습니다."));
    }


    /** 주문 검색 **/
    public List<Order> findOrders(OrderSearch orderSearch) {
        return orderRepository.findAllByString(orderSearch);
    }


}
