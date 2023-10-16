package com.example.backend.dto;

import com.example.backend.entity.UserEntity;
import com.example.backend.model.UserType;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;

@Getter
@AllArgsConstructor
public class UserDTO implements UserDetails {

    private Long id;
    private String userNum;
    private String userPwd;
    private String userName;
    private UserType userType;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.userPwd;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public static UserDTO fromEntity(UserEntity userEntity) {
        return new UserDTO(
                userEntity.getId(),
                userEntity.getUserNum(),
                userEntity.getUserPwd(),
                userEntity.getUserName(),
                userEntity.getUserType()
        );
    }
}
