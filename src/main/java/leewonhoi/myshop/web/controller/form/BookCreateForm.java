package leewonhoi.myshop.web.controller.form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;

@Getter @Setter
public class BookCreateForm {
    // 검색용
    private String id;

    @NotBlank
    private String name;

    @Positive @NotNull
    @NumberFormat(pattern = "###,###")
    private int price;

    @Positive @NotNull
    private int stockQuantity;

    private String author;
    private String isbn;

}
