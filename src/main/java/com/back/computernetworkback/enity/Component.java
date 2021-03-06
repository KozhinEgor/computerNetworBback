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

    @JsonProperty("name")
    private String name;

    @JsonProperty("characteristick")
    private String characteristick;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_category_component")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private CategoryComponent categoryComponent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_vendor")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Vendor vendor;

}
