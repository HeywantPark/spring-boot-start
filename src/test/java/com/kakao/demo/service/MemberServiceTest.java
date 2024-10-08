package com.kakao.demo.service;

import com.kakao.demo.domain.Member;
import com.kakao.demo.repository.MemoryMemberRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepo memoryMemberRepo;

    @BeforeEach
    public void beforeEach(){
        memoryMemberRepo = new MemoryMemberRepo();
        memberService = new MemberService(memoryMemberRepo);
    }

    @AfterEach
    public void afterEach () {
        memoryMemberRepo.clearStore();
    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("trust.skip.jo");
        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void findMember() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        //then
    }

    @Test
    void findOne() {
    }
}