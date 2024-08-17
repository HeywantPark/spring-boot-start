package com.kakao.demo;

import com.kakao.demo.repository.MemberRepo;
import com.kakao.demo.repository.MemoryMemberRepo;
import com.kakao.demo.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepo());
    }
    @Bean
    public MemberRepo memberRepo() {
        return new MemoryMemberRepo();
    }
}
