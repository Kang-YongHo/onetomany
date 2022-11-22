package com.onetomany.case1.modules.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {


    private final CommentRepository commentRepository;


    @Transactional
    public void create(){

    }


}
