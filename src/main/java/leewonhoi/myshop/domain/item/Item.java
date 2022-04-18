package leewonhoi.myshop.domain.item;

import leewonhoi.myshop.web.controller.form.BookUpdateForm;
import leewonhoi.myshop.web.exception.NotEnoughStockException;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@DiscriminatorColumn
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    // === 비즈니스 로직 === //
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0) {
            throw new NotEnoughStockException("재고가 부족합니다.");
        }

        this.stockQuantity = restStock;
    }

    public void initItem(String itemName, int price, int quantity) {
        this.name = itemName;
        this.price = price;
        this.stockQuantity = quantity;
    }

    public void updateItem(BookUpdateForm bookUpdateForm) {
        this.name = bookUpdateForm.getName();
        this.price = bookUpdateForm.getPrice();
        this.stockQuantity = bookUpdateForm.getStockQuantity();
    }


}
