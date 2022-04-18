package leewonhoi.myshop.service;

import leewonhoi.myshop.domain.item.Book;
import leewonhoi.myshop.domain.item.Item;
import leewonhoi.myshop.repository.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ItemServiceIntegrateTest {

    @Autowired
    ItemService itemService;

    @Test
    void 아이템저장() {
        // given
        Item item = new Book();
        item.initItem("itemA", 1000, 1);


        // when
        Long savedItem = itemService.saveItem(item);
        Item findItem = itemService.findItem(savedItem);

        // then
        assertThat(item.getName()).isEqualTo(findItem.getName());
        assertThat(item.getPrice()).isEqualTo(findItem.getPrice());
        assertThat(item.getStockQuantity()).isEqualTo(findItem.getStockQuantity());
    }

    @Test
    void 아이템_전체조회() {
        // given
        Book itemA = new Book();
        itemA.initItem("itemA", 1000, 1);

        Book itemB = new Book();
        itemB.initItem("itemB", 1000, 1);

        // when
        itemService.saveItem(itemA);
        itemService.saveItem(itemB);

        List<Item> result = itemService.findAllItem();

        // then
        assertThat(result.size()).isEqualTo(2);
    }
}