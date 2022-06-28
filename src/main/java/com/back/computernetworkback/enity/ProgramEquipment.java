package com.back.computernetworkback.enity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "program_equipment", schema = "computernetwork")
public class ProgramEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="program_key", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ProgramKey programKey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="equipment")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Equipment equipment;
}
