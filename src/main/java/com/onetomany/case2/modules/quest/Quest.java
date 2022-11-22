package com.onetomany.case2.modules.quest;

import com.onetomany.case2.modules.member.Member;
import com.onetomany.case2.modules.reply.Reply;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "member_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    private String title;

    @Column(length = 1000)
    private String content;

    @OneToMany(mappedBy = "quest")
    private List<Reply> replies;

    @Builder
    public Quest(Long id, Member member, String title, String content, List<Reply> replies) {
        this.id = id;
        this.member = member;
        this.title = title;
        this.content = content;
        this.replies = replies;
    }
}
