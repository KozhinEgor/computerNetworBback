package com.back.computernetworkback.enity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


import javax.persistence.*;

@Entity
@Table(name = "user", schema = "computernetwork")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_otdel", nullable=false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Otdel otdel;

}
