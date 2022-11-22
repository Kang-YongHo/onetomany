package com.onetomany.case2.modules;

import com.onetomany.case2.modules.member.MemberService;
import com.onetomany.case2.modules.quest.QuestService;
import com.onetomany.case2.modules.reply.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class Case2Controller {

    private final MemberService memberService;
    private final QuestService questService;
    private final ReplyService replyService;

    @PostMapping("/member")
    public void createMember(){
        memberService.create();
    }

    @PostMapping("/quest")
    public void createQuest(){
        questService.create();
    }

    @PostMapping("/reply")
    public void createReply(){
        replyService.create();
    }

    @DeleteMapping("/delete")
    public void delete(){
        memberService.delete();
    }
}

