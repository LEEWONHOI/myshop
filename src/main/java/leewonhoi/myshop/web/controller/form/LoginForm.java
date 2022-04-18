package leewonhoi.myshop.web.controller.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class LoginForm {

    @NotBlank
    private String loginId;

    @NotBlank
    private String password;

}
