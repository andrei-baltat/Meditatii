package com.example.meditatii.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;

    @ManyToOne
    // ASK: asta se citeste ca MANY pets can have one owner?
    // R: asta se citeste ca MANY pets sunt asignate la un owner?
    @JoinColumn(name = "owners_id")
//    deci unde ai @JoinColumn inseamna ca asta este tabela parinte, si ai o referinta catre owners
    private Owner owner;

    @ManyToMany(mappedBy = "pets")
    private Set<Doctor> doctors;
}
