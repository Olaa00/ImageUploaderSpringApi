package com.olaapp.imageuploader;
/* klasa posredniczy miedzy DB a interfejsem logowania, wyciaga info na temat usera i sprawdza czy haslo jest OK
* */

import com.olaapp.imageuploader.model.User;
import com.olaapp.imageuploader.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service //klasa zarzadzana tez przez kontekst springa, wyciganie uzytkownikow
public class  UserDetailsServiceImpl implements UserDetailsService {
    private UserRepo userRepo;
    @Autowired
    public UserDetailsServiceImpl(UserRepo userRepo ) {

        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepo.findByUsername(s); //obiekt user zwracany
    }

}
