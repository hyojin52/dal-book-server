package org.project.dalantbook.controller;

import lombok.RequiredArgsConstructor;
import org.project.dalantbook.controller.request.AccountCreateRequest;
import org.project.dalantbook.controller.request.AccountLoginRequest;
import org.project.dalantbook.controller.response.Response;
import org.project.dalantbook.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/join")
    public Response createAccount(@RequestBody AccountCreateRequest request) {
        accountService.createAccount(request);
        return Response.success();
    }

    @PostMapping("/login")
    public ResponseEntity<Response> loginAccount(@RequestBody AccountLoginRequest request) {
        String token = accountService.login(request);
        return ResponseEntity.ok()
                .header("Authorization", "Bearer " + token)
                .body(Response.success(token));
    }
}
