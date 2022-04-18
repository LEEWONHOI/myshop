package leewonhoi.myshop.web.controller.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class BookUpdateForm {

    private Long id;

    @NotBlank
    private String name;

    @NumberFormat(pattern = "###,###")
    private int price;

    private int stockQuantity;

    private String author;
    private String isbn;
}
