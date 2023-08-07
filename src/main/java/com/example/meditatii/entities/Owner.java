package com.example.meditatii.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "owners")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
//    ask: fetchtype lazy inseamna ca obiectul are pet = null la creere, si doar daca faci getPet,
//    efectiv iti aduce lista de pets?
    // ASK: asta se citeste ca ONE owner can have multiple pets?
//    ASK: vezi si cascade
    private Set<Pet> pet;

    /**
     * daca e eager -> faci get pe owner is vin si pet
     * daca e lazy -> NU se incarca pet-ul, trebuie sa faci get
     *
     */

}
