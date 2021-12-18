package com.salesianostriana.dam.modelo;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Category {

    @GeneratedValue @Id
    private Long id;

    private String name;

}
