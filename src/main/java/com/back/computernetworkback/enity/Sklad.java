package com.back.computernetworkback.enity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sklad", schema = "computernetwork")
public class Sklad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("number")
    private Long number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="component")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Component component;
}
