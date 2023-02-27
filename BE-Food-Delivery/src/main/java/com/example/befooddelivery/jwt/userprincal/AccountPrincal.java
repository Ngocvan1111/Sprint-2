package com.example.befooddelivery.jwt.userprincal;

import com.example.befooddelivery.entity.account.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AccountPrincal implements UserDetails {
    private Long idAccount;
    private String email;
    private String name;
    @JsonIgnore
    private String encryptPassword;
    private Collection<? extends GrantedAuthority> roles;

    public AccountPrincal(Long idAccount, String name, String email, String encryptPassword, List<GrantedAuthority> authorities) {
        this.idAccount = idAccount;
        this.email = email;
        this.encryptPassword = encryptPassword;
        this.roles = authorities;
        this.name = name;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public AccountPrincal() {
    }

    public AccountPrincal(Long idAccount, String email, String encryptPassword, Collection<? extends GrantedAuthority> roles) {
        this.idAccount = idAccount;
        this.email = email;
        this.encryptPassword = encryptPassword;
        this.roles = roles;
    }
    public static AccountPrincal build(Account account){
        List<GrantedAuthority> authorities = account.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
        return new AccountPrincal(
                account.getIdAccount(),
                account.getName(),
                account.getEmail(),
                account.getEncryptPassword(),
                authorities
        );
    }

    @Override
    public String getPassword() {
        return encryptPassword;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEncryptPassword() {
        return encryptPassword;
    }

    public void setEncryptPassword(String encryptPassword) {
        this.encryptPassword = encryptPassword;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }
}
