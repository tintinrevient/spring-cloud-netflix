package io.github.tintinrevient.oauthserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Arrays;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String username;
//    @JsonIgnore
    private String password;
    private long salary;
    private int age;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
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

}
