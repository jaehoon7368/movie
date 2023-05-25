package com.sh.movie.config.auth.dto;

import com.sh.movie.domain.user.MUser;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionMUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionMUser(MUser user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}