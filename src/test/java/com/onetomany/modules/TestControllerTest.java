package com.onetomany.modules;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.onetomany.MockMvcTest;
import com.onetomany.modules.account.Account;
import com.onetomany.modules.account.AccountRepository;
import com.onetomany.modules.account.AccountService;
import com.onetomany.modules.comment.Comment;
import com.onetomany.modules.comment.CommentRepository;
import com.onetomany.modules.post.Post;
import com.onetomany.modules.post.PostRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

@MockMvcTest
class TestControllerTest {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    AccountService accountService;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        Account account = Account.builder()
            .nickname("account")
            .email("a@a.com")
            .posts(new ArrayList<>())
            .comments(new ArrayList<>())
            .build();

        Account saveAccount = accountRepository.save(account);

        Post post = Post.builder()
            .title("title")
            .content("content")
            .account(saveAccount)
            .comments(Collections.EMPTY_LIST)
            .build();

        Post savePost = postRepository.save(post);

        Comment comment = Comment.builder()
            .content("예스 코멘트")
            .post(savePost)
            .account(saveAccount)
            .build();
        Comment saveComment = commentRepository.save(comment);

        saveAccount.update(savePost, saveComment);
//        savePost.addComment(saveComment);


    }

    @DisplayName("삭제 테스트")
    @Test
    void create_three_entities() throws Exception {
        accountRepository.deleteById(1L);

        assertThat(accountRepository.count()).isEqualTo(0);
        assertThat(postRepository.count()).isEqualTo(0);
        assertThat(commentRepository.count()).isEqualTo(0);
    }

}