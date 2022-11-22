package com.onetomany.case1.modules;

import com.onetomany.case1.modules.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Case1Controller {

    private final AccountService accountService;

    @DeleteMapping("/test/{id}")
    public void delete(@PathVariable Long id){
        accountService.delete(id);
    }
}
