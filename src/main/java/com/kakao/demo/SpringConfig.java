package com.kakao.demo;

import com.kakao.demo.repository.*;
import com.kakao.demo.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
     public MemberService memberService() {
        return new MemberService(memberRepo());
    }
    @Bean
    public MemberRepo memberRepo() {
//        return new MemoryMemberRepo();
//        return new JdbcMemberRepo(dataSource);
//        return new JdbcTemplateMerberRepo(dataSource);
        return new JpaMemberRepo(em);
    }
}
