package com.finalBackEnd1.clinicaOdontologica.login;


import com.finalBackEnd1.clinicaOdontologica.entity.AppUser;
import com.finalBackEnd1.clinicaOdontologica.entity.AppUsuarioRoles;
import com.finalBackEnd1.clinicaOdontologica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    private final UserRepository userRepository;

    //Constructor
    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("password");
        String password2 = passwordEncoder.encode("password2");

        userRepository.save(new AppUser("admin","admin","admin@admin.com",password, AppUsuarioRoles.ADMIN));
        userRepository.save(new AppUser("user","user","user@user.com",password2, AppUsuarioRoles.USER));
    }
}
