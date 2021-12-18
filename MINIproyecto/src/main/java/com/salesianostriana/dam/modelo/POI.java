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

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "poi_id",
            foreignKey = @ForeignKey(name="FK_ROUTE_POI")),
            inverseJoinColumns = @JoinColumn(name = "route_id",
                    foreignKey = @ForeignKey(name="FK_ROUTE_POI")),
            name = "route")
    private List<Route> route = new ArrayList<>();



}
