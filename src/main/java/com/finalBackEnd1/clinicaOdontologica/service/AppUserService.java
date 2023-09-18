package com.finalBackEnd1.clinicaOdontologica.service;

import com.finalBackEnd1.clinicaOdontologica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    public AppUserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetails detallesUsuario = userRepository.findByEmail(email).orElseThrow((() -> new UsernameNotFoundException("Usuario no encontrado")));
        System.out.println("Usuario: " + detallesUsuario.getUsername() + " Password Encriptada: " + detallesUsuario.getPassword() + " Role: " +
                detallesUsuario.getAuthorities());
        return  detallesUsuario;
/*
        UserDetails userDetails = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        authorities.forEach(authority -> {
            System.out.println("Role: " + authority.getAuthority());
        });
        return userDetails;
    }

 */
    }
}
