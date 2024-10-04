package org.project.dalantbook.service;

import lombok.RequiredArgsConstructor;
import org.project.dalantbook.domain.Account;
import org.project.dalantbook.domain.AccountEntity;
import org.project.dalantbook.domain.respository.AccountRepository;
import org.project.dalantbook.exception.DalantBookApplicationException;
import org.project.dalantbook.exception.ErrorCode;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountEntity accountEntity = accountRepository.findByUserId(username).orElseThrow(() ->
                new DalantBookApplicationException(ErrorCode.NOT_FOUND_ACCOUNT));
        return Account.of(accountEntity);
    }
}
