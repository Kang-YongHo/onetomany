package com.onetomany.case1.modules.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {


    private final PostRepository postRepository;


    @Transactional
    public void create(){

    }


}
