package com.xiao9.user.facade.rest;

import com.xiao9.user.facade.rest.view.LoginDTO;
import com.xiao9.user.infrastruction.security.jwt.JWTFilter;
import com.xiao9.user.infrastruction.security.jwt.TokenProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserLoginController {

    private final TokenProvider tokenProvider;

    private AuthenticationManagerBuilder authenticationManagerBuilder;

    public UserLoginController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }


    @PostMapping("/authenticate")
    public ResponseEntity<JWTToken> authorize(@RequestBody LoginDTO login) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                login.getUsername(), login.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        boolean remember = login.getRememberMe() == null ? false : login.getRememberMe();
        String jwt = tokenProvider.createToken(authentication, remember);
        HttpHeaders headers = new HttpHeaders();
        headers.add(JWTFilter.AUTHORIZATION_HEADER, jwt);
        return new ResponseEntity<>(new JWTToken(jwt), headers, HttpStatus.OK);
    }


}
