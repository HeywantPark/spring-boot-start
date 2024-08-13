package com.kakao.demo.repository;

import com.kakao.demo.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepoTest {
    MemoryMemberRepo memberRepo = new MemoryMemberRepo();

    @AfterEach
    public void afterEach () {
        memberRepo.clearStore();
    }
    @Test
    public void save() {
        Member member = new Member();
        member.setName("hyewon");

        memberRepo.save(member);

        Member result = memberRepo.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }
    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        memberRepo.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberRepo.save(member2);

        Member result  = memberRepo.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }
    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        memberRepo.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberRepo.save(member2);

        List<Member> result = memberRepo.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
