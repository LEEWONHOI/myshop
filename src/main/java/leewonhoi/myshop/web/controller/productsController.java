package leewonhoi.myshop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class productsController {

    @GetMapping("/products")
    public String productsList() {
        return "/products";
    }

}
