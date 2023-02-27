package com.example.befooddelivery.controller.security;

import com.example.befooddelivery.dto.account.request.SignInForm;
import com.example.befooddelivery.dto.account.response.JwtResponse;
import com.example.befooddelivery.jwt.jwt.JwtProvider;
import com.example.befooddelivery.jwt.jwt.JwtTokenFilter;
import com.example.befooddelivery.jwt.userprincal.AccountPrincal;
import com.example.befooddelivery.service.account.IAccountService;
import com.example.befooddelivery.service.account.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/public")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SecurityController {
    @Autowired
    IAccountService accountService;
//    @Autowired
//    IRoleService roleService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    JwtTokenFilter jwtTokenFilter;

    @PostMapping("/signin")
    public ResponseEntity<?> login(@Valid @RequestBody SignInForm signInForm) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInForm.getEmail(), signInForm.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.createToken(authentication);
        AccountPrincal accountPrinciple = (AccountPrincal) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(token,
                accountPrinciple.getName(),
                accountPrinciple.getAuthorities(),
                accountPrinciple.getIdAccount(),
                accountPrinciple.getEmail()));

    }
}
