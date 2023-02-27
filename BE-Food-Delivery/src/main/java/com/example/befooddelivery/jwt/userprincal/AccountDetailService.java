package com.example.befooddelivery.jwt.userprincal;

import com.example.befooddelivery.entity.account.Account;
import com.example.befooddelivery.repository.account.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountDetailService implements UserDetailsService {
    @Autowired
    IAccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(email).orElseThrow(()->new
                UsernameNotFoundException("Account không tồn tại" + email));
        return AccountPrincal.build(account);
    }
}
