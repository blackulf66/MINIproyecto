package com.salesianostriana.dam.dto.POI;
import com.salesianostriana.dam.modelo.POI;
import org.springframework.stereotype.Component;

@Component
public class POIDtoConverter {
        public POI createPOIDtoToPOI(CreatePOIDto c){
            return new POI(
                    c.getId(),
                    c.getName(),
                    c.getLocation(),
                    c.getDescripcion(),
                    c.getDate(),
                    c.getCoverPhoto(),
                    c.getPhoto2(),
                    c.getPhoto3(),
                    c.getCategory(),
                    c.getRoutes()
            );
        }
        public GetPOIDto POIToGetPOIDto(POI p){
            return GetPOIDto.builder()
                    .id(p.getId())
                    .name(p.getName())
                    .category(p.getCategory())
                    .coverPhoto(p.getCoverPhoto())
                    .date(p.getDate())
                    .descripcion(p.getDescripcion())
                    .photo2(p.getPhoto2())
                    .photo3(p.getPhoto3())
                    .location(p.getLocation())
                    .routes(p.getRoute())
                    .build();
        }
    }

