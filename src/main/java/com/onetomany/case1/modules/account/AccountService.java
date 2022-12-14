package com.onetomany.case1.modules.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService {


    private final AccountRepository accountRepository;

    @Transactional
    public void delete(Long id){
        Account account = accountRepository.findById(id)
            .orElseThrow();

        accountRepository.delete(account);

    }


}
