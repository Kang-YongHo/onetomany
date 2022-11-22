package com.onetomany.case2.modules.quest;


import com.onetomany.case2.modules.member.Member;
import com.onetomany.case2.modules.member.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class QuestService {

    private final QuestRepository questRepository;
    private final MemberRepository memberRepository;

    public void create(){

        Member member = Optional.of(memberRepository.findAll().get(0))
            .orElseThrow();

        Quest quest = Quest.builder()
            .title("quest - title")
            .content("quest - content")
            .member(member)
            .build();

        Quest save = questRepository.save(quest);
        log.info("퀘스트 저장 :: '{}'" , save);
    }
}
