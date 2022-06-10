package com.back.computernetworkback.enity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "program_key", schema = "computernetwork")
public class ProgramKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="program")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Program program;

    @JsonProperty("value")
    private String value;

    @JsonProperty("date_start")
    private LocalDate date_start;

    @JsonProperty("date_finish")
    private LocalDate date_finish;
}
