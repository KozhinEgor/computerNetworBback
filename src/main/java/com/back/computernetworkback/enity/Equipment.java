package com.back.computernetworkback.enity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "equipment", schema = "computernetwork")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_user", nullable=false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_category_equipment", nullable=false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private CategoryEquipment category_equipment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_otdel", nullable=false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Otdel otdel;
}
