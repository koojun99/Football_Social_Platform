package com.example.football_community.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum GlobalErrorCode {

    //Memmber
    // 400 BAD_REQUEST - 잘못된 요청
    NOT_VALID_EMAIL(BAD_REQUEST, "유효하지 않은 이메일 입니다."),
    PASSWORD_MISMATCH(BAD_REQUEST, "비밀번호가 일치하지 않습니다."),
    DUPLICATE_PASSWORD(BAD_REQUEST, "비밀번호가 동일합니다."),
    DUPLICATE_NICK_NAME(BAD_REQUEST, "중복된 닉네임이 존재합니다."),
    NOT_VALID_NICKNAME(BAD_REQUEST, "영문, 한글, 숫자를 포함한 2~ 16글자를 입력해 주세요."),
    NOT_VALID_PASSWORD(BAD_REQUEST, "영문, 숫자, 특수문자를 포함한 8~20 글자를 입력해 주세요."),
    NOT_VALID_PHONENUMBER(BAD_REQUEST, "11자리 이내의 번호를 '-'를 제외한 숫자만 입력해 주세요."),

    // 401 Unauthorized - 권한 없음
    INVALID_TOKEN(UNAUTHORIZED, "토큰이 유효하지 않습니다"),
    LOGIN_REQUIRED(UNAUTHORIZED, "로그인이 필요한 서비스입니다."),
    INVALID_CODE(UNAUTHORIZED, "유효하지 않은 코드입니다"),

    AUTHENTICATION_REQUIRED(UNAUTHORIZED, "인증 정보가 유효하지 않습니다."),
    // 404 Not Found - 찾을 수 없음
    EMAIL_NOT_FOUND(NOT_FOUND, "존재하지 않는 이메일 입니다."),
    NEED_AGREE_REQUIRE_TERMS(NOT_FOUND, "필수 약관에 동의해 주세요"),
    MEMBER_NOT_FOUND(NOT_FOUND, "등록되지 않은 회원입니다."),
    USERINFO_NOT_FOUND(NOT_FOUND, "등록된 사용자 정보가 없습니다"),
    // 409 CONFLICT : Resource 를 찾을 수 없음
    DUPLICATE_EMAIL(CONFLICT, "중복된 이메일이 존재합니다"),

    //Post
    //401 Unauthorized
    ACCESS_DENIED(UNAUTHORIZED, "권한이 없습니다."),
    //404 Not Found
    POST_NOT_FOUND(NOT_FOUND, "게시글을 찾을 수 없습니다."),

    //Team
    //404 Not Found
    TEAM_NOT_FOUND(NOT_FOUND, "축구 팀을 찾을 수 없습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
