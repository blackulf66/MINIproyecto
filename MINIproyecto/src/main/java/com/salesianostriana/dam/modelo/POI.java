package com.salesianostriana.dam.modelo;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class POI implements Serializable {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private String location;

    @Lob
    private String descripcion;

    private LocalDateTime date;

    private String coverPhoto;

    private String photo2;

    private String photo3;

    @ManyToOne
    @JoinColumn(name = "category", foreignKey = @ForeignKey(name = "FK_POI_Category"))
    private Category category;

    //helpers
    public void addToRoute(Route r){r.getSteps().add(this);}

    public void removeFromRoute(Route u) {u.getSteps().remove(this);u = null;}

    public void nullcategory(Category c){
        if (c.getName() == null){
            c.setName("sin categoria");
        }else{

        }
    }



}
