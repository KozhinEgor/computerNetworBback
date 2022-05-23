package com.back.computernetworkback.enity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "component", schema = "computernetwork")
public class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("number")
    private Long number;


    @JsonProperty("name")
    private String name;

    @JsonProperty("characteristick")
    private String characteristick;

    @JsonProperty("srock")
    private LocalDate srock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_category_component")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Equipment equipment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_vendor")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Vendor vendor;

}
