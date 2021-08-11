package edu.miu.authserver.util.userdetails;

import edu.miu.authserver.model.UserAccess;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Transactional
public class UserDetailsimp implements UserDetails {
    private static final long serialVersionUID = 1L;
    private final UserAccess userAccess;
    private final Collection<? extends GrantedAuthority> authorities;

    public UserDetailsimp(UserAccess userAccess, Collection<? extends GrantedAuthority> authorities) {
        this.userAccess = userAccess;
        this.authorities = authorities;
    }

    public static UserDetailsimp build(UserAccess user) {

        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
        System.out.println(user.getRoles()+"=================");
        return new UserDetailsimp(
                user,
                authorities);
    }

    public UserAccess getUserDetails(){
        return this.userAccess;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return userAccess.getPassword();
    }

    @Override
    public String getUsername() {
        return userAccess.getUsername();
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
    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsimp user = (UserDetailsimp) o;
        return Objects.equals(userAccess.getId(), user.getUserDetails().getId());
    }
}
