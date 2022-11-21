package com.onetomany.modules.account;

import com.onetomany.modules.comment.Comment;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findById(Long id);

    void deleteAllByEmail(String email);
}
