package com.kakao.demo.service;

import com.kakao.demo.domain.Member;
import com.kakao.demo.repository.MemberRepo;
import com.kakao.demo.repository.MemoryMemberRepo;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepo memberRepo;

    public MemberService(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }
    //회원 가입
    public Long join(Member member) {
        // 중복 회원 검증
        validateDupMember(member);
        memberRepo.save(member);
        return member.getId();
    }

    private void validateDupMember(Member member) {
        memberRepo.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }
    //전체 회원 조회
    public List<Member> findMember() {
        return memberRepo.findAll();
    }
    //특정 회원 조회
    public Optional<Member> findOne(Long memberId) {
        return memberRepo.findById(memberId);
    }
}
