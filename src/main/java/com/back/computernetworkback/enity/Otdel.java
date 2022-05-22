package com.back.computernetworkback.enity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "otdel", schema = "computernetwork")
public class Otdel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
}
