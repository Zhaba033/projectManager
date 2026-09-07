package com.mycompany.projectmanager.service;

import com.mycompany.projectmanager.entity.Account;
import com.mycompany.projectmanager.repository.AccountRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService{
    
    private final AccountRepository accountRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = null;
        
        if (accountRepository.existsByUsername(username)) {
            Account user = accountRepository.findByUsername(username);
            password = user.getPassword();
        } else {    
            throw new UsernameNotFoundException("Пользователь не найден: " + username);
        }
       
        
        return User.builder()
            .username(username)
            .password(password)
            .build();
    }
}