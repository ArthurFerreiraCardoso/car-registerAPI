package com.teste.wswork.carregisterAPI.models;

import javax.persistence.*;import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "model")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "brand")
    private Brand brand;
    @Column(name = "name")
    private String name;
    @Column(name = "fipe_value")
    private double fipeValue;
}
