package com.onetomany.case2.modules.reply;

import com.onetomany.case2.modules.member.Member;
import com.onetomany.case2.modules.member.MemberRepository;
import com.onetomany.case2.modules.quest.Quest;
import com.onetomany.case2.modules.quest.QuestRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final MemberRepository memberRepository;
    private final QuestRepository questRepository;

    public void create(){
        Member member = Optional.of(memberRepository.findAll().get(0))
            .orElseThrow();
        Quest quest = Optional.of(questRepository.findAll().get(0))
            .orElseThrow();

        Reply reply = Reply.builder()
            .content("reply - content")
            .member(member)
            .quest(quest)
            .build();

        Reply save = replyRepository.save(reply);
        log.info("댓글 저장 :: '{}'" , save);
    }
}
