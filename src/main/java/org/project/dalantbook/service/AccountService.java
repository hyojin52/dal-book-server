package org.project.dalantbook.service;

import lombok.RequiredArgsConstructor;
import org.project.dalantbook.controller.request.AccountCreateRequest;
import org.project.dalantbook.controller.request.AccountLoginRequest;
import org.project.dalantbook.domain.AccountEntity;
import org.project.dalantbook.domain.ChurchEntity;
import org.project.dalantbook.domain.enums.AccountRole;
import org.project.dalantbook.domain.respository.AccountRepository;
import org.project.dalantbook.domain.respository.ChurchRepository;
import org.project.dalantbook.exception.DalantBookApplicationException;
import org.project.dalantbook.exception.ErrorCode;
import org.project.dalantbook.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final ChurchRepository churchRepository;

    private final BCryptPasswordEncoder encoder;

    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${jwt.token.expired-time-ms}")
    private Long expiredTimeMs;

    public void createAccount(AccountCreateRequest request) {
        accountRepository.findByUserId(request.getUserId()).ifPresent((it) -> {
                throw new DalantBookApplicationException(ErrorCode.ACCOUNT_EXISTS);
        });

        ChurchEntity churchEntity = churchRepository.findById(request.getChurchId()).orElseThrow(() ->
                new DalantBookApplicationException(ErrorCode.NOT_FOUND_CHURCH));
        AccountEntity account = new AccountEntity();
        account.setUserId(request.getUserId());
        account.setUserPassword(encoder.encode(request.getPassword()));
        account.setChurch(churchEntity);
        account.setRole(AccountRole.ROLE_USER);
        accountRepository.save(account);

    }

    public String login(AccountLoginRequest request) {
        AccountEntity accountEntity = accountRepository.findByUserId(request.getUserId()).orElseThrow(() ->
            new DalantBookApplicationException(ErrorCode.NOT_FOUND_ACCOUNT));

       if(!encoder.matches(request.getPassword(), accountEntity.getUserPassword())) {
           throw new DalantBookApplicationException(ErrorCode.INVALID_PASSWORD);
       }

        String token = JwtTokenUtils.generateToken(request.getUserId(), secretKey, expiredTimeMs);
        return token;
    }



}
