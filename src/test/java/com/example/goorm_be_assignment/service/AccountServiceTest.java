package com.example.goorm_be_assignment.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.goorm_be_assignment.dto.AccountForm;
import com.example.goorm_be_assignment.entity.Account;
import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AccountServiceTest {
    @Autowired
    private AccountService accountService;

//    @Test
//    @Transactional
//    void create_성공() {
//        //1. 예상 데이터
//        String title="라라라라";
//        String content="4444";
//        ArticleForm dto=new ArticleForm(null,title,content);
//        Article expected=new Article(4L,title,content);
//        //2. 실제 데이터
//        Article article=articleService.create(dto);
//        //3. 검증
//        assertEquals(expected.toString(),article.toString());
//    }

    //회원가입
    @Test
    void 회원가입_성공_일반회원(){

        //1. 예상 데이터 세팅
        String name="테스트";
        String id="testid";
        String pw="testpw";
        LocalDate birth=LocalDate.of(2001,3,24);
        LocalTime createAt= LocalTime.now();
        String email="test@naver.com";
        Integer role=0;

        AccountForm dto=new AccountForm(name,id,pw,birth,createAt,email,role);
        Account expected=new Account(name,id,pw,birth,createAt,email,role);
        //2. 실제 데이터 세팅
        Account account= accountService.create(dto);
        //3. 검증
        assertEquals(expected,account);


    }
    @Test
    void 회원가입_성공_관리자(){
        //이름
        //ID
        //PW
        //
        String name="관리자";
        String id="adminid";
        String pw="adminpw";
        LocalDate birth=LocalDate.of(2001,3,24);
        LocalTime createAt= LocalTime.now();
        String email="admin@naver.com";
        Integer role=1;

        AccountForm dto=new AccountForm(name,id,pw,birth,createAt,email,role);
        Account expected=new Account(name,id,pw,birth,createAt,email,role);
        //2. 실제 데이터 세팅
        Account account=accountService.create(dto);
        //3. 검증
        assertEquals(expected,account);


    }

    //로그인
    @Test
    void 로그인_성공(){
        String ID="testid";
        String PW="testpw";

    }

    //관리자 로그인



}