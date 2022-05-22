package com.back.computernetworkback.dto;

import com.back.computernetworkback.enity.Otdel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class UserDto {
    @JsonProperty("email")
    private String email;

    @JsonIgnore
    private String password;
    @JsonProperty("role")
    private String role;
    @JsonProperty("fio")
    private String fio;
    @JsonProperty("dolzhnost")
    private String dolzhnost;

    @JsonProperty("otdel")
    private Otdel otdel;
}
