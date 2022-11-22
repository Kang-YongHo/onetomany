package com.onetomany.modules;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.onetomany.MockMvcTest;
import com.onetomany.case1.modules.account.Account;
import com.onetomany.case1.modules.account.AccountRepository;
import com.onetomany.case1.modules.account.AccountService;
import com.onetomany.case1.modules.comment.Comment;
import com.onetomany.case1.modules.comment.CommentRepository;
import com.onetomany.case1.modules.post.Post;
import com.onetomany.case1.modules.post.PostRepository;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

@MockMvcTest
class TestControllerCase1 {

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