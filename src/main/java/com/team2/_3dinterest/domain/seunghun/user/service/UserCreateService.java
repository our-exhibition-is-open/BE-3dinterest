package com.team2._3dinterest.domain.seunghun.user.service;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateService {
    @Size(min = 3, max = 25)
    @NotEmpty(message = "사용자ID는 필수항목입니다.")
    private String username;

    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String password1;

    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String password2;

    @NotEmpty(message = "이메일은 필수항목입니다.")
    @Email
    private String email;

    public void create(String username, String email, String password) {
        // 실제 사용자 생성 로직을 구현
        // username, email, password 등을 사용하여 사용자를 생성하는 코드를 작성
        // 예를 들어, UserRepository를 사용하여 DB에 사용자 정보를 저장하는 등의 작업이 여기에 들어갑니다.
    }

}