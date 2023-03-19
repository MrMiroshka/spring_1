package ru.miroshka.hw11.servicies;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.miroshka.hw11.data.Authority;
import ru.miroshka.hw11.data.Role;
import ru.miroshka.hw11.data.User;
import ru.miroshka.hw11.repositories.UserRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public Optional<User> findByUsername(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = findByUsername(userName).orElseThrow(() -> new UsernameNotFoundException(String.format("User '%s' not found", userName)));
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), getAuthorities(user.getRoles(), user.getAuthorities()));
    }

    private Collection<SimpleGrantedAuthority> getAuthorities (Collection<Role> roles,Collection<Authority> authorities){
        Collection<SimpleGrantedAuthority> a = mapAuthorityToAuthorities(authorities);
        Collection<SimpleGrantedAuthority> r = (mapRolesToAuthorities(roles));
        if (a!=null && r == null){
            return a;
        }
        if(r!=null && a == null){
            return r;
        }
        if(r!=null && a != null){
            r.addAll(a);
            return r;
        }

        return null;
    }

    private Collection<SimpleGrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

    }

    private Collection<SimpleGrantedAuthority> mapAuthorityToAuthorities(Collection<Authority> authorities) {
        return authorities.stream().map(authority -> new SimpleGrantedAuthority(authority.getName())).collect(Collectors.toList());
    }
}
