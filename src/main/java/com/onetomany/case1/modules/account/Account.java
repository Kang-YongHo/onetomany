package com.onetomany.case1.modules.account;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.onetomany.case1.modules.comment.Comment;
import com.onetomany.case1.modules.post.Post;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    private String email;

    @JsonManagedReference
    @OneToMany(mappedBy = "account", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "account", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Account(Long id, String nickname, String email, List<Post> posts,
        List<Comment> comments) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.posts = posts;
        this.comments = comments;
    }

    public void update(Post savePost, Comment saveComment) {
        this.posts.add(savePost);
        this.comments.add(saveComment);
    }
}
