package com.kakao.demo;

import com.kakao.demo.repository.JdbcMemberRepo;
import com.kakao.demo.repository.MemberRepo;
import com.kakao.demo.repository.MemoryMemberRepo;
import com.kakao.demo.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepo());
    }
    @Bean
    public MemberRepo memberRepo() {
//        return new MemoryMemberRepo();
        return new JdbcMemberRepo(dataSource);
    }
}
