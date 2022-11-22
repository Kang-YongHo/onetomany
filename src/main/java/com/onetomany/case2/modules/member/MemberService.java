package com.onetomany.case2.modules.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void create(){
        Member member = Member.builder()
            .nickname("test")
            .email("a@a.com")
            .build();

        Member save = memberRepository.save(member);
        log.info("멤버 저장 :: '{}'", save);
    }

    public void delete() {
        Member member = memberRepository.findById(1L)
            .orElseThrow();

        memberRepository.delete(member);

        log.info("멤버 삭제");
    }
}
