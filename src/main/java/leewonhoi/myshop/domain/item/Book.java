package leewonhoi.myshop.domain.item;


import leewonhoi.myshop.web.controller.form.BookUpdateForm;
import lombok.Getter;

import javax.persistence.Entity;

@Entity
@Getter
public class Book extends Item {

    private String author;
    private String isbn;

    public void initBook(String author, String isbn) {
        this.author = author;
        this.isbn = isbn;
    }

    public void updateBook(BookUpdateForm bookUpdateForm) {
        this.author = bookUpdateForm.getAuthor();
        this.isbn = bookUpdateForm.getIsbn();
    }

}
