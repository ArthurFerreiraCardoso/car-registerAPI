package com.teste.wswork.carregisterAPI.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "register_at", length = 100, nullable = false)
    private LocalDateTime timestampRegister;
    @ManyToOne
    @JoinColumn(name = "model")
    private Model model;
    @Column(name = "year")
    private int year;
    @Column(name = "gas")
    private String gas;
    @Column(name = "number_doors")
    private int numDoors;
    @Column(name = "color")
    private String color;

    @PrePersist
    protected void onCreate() {
        timestampRegister = LocalDateTime.now();
    }
}
