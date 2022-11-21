package com.onetomany.modules.post;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.onetomany.modules.account.Account;
import com.onetomany.modules.comment.Comment;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
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
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    private String title;

    private String content;

    @JoinColumn(name = "account_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    @JsonManagedReference
    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Post(Long id, String title, String content, Account account, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.account = account;
        this.comments = comments;
    }


    public void addComment(Comment comment){
        comment.addPost(this);
        this.getComments().add(comment);
    }
}
