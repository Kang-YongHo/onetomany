package com.onetomany.modules.comment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.onetomany.modules.account.Account;
import com.onetomany.modules.post.Post;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    private String content;
    @JsonBackReference
    @JoinColumn(name = "post_id")
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Post post;

    @JsonBackReference
    @JoinColumn(name = "account_id")
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Account account;

    @Builder
    public Comment(Long id, String content, Post post, Account account) {
        this.id = id;
        this.content = content;
        this.post = post;
        this.account = account;
    }


    public void addPost(Post post){
        this.post = post;
    }
}
