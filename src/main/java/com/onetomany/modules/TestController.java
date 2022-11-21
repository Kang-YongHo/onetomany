package com.onetomany.modules;

import com.onetomany.modules.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final AccountService accountService;

    @DeleteMapping("/test/{id}")
    public void delete(@PathVariable Long id){
        accountService.delete(id);
    }
}
