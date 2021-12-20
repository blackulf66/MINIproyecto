package com.salesianostriana.dam.dto.POI;
import com.salesianostriana.dam.modelo.POI;
import com.salesianostriana.dam.servicios.CategoryService;
import com.salesianostriana.dam.servicios.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class POIDtoConverter {
    @Autowired
    private CategoryService categoryService;
    private RouteService routeService;

        public POI createPOIDtoToPOI(CreatePOIDto c){
            return POI.builder()
                    .name(c.getName())
                    .coverPhoto(c.getCoverPhoto())
                    .date(c.getDate())
                    .descripcion(c.getDescripcion())
                    .photo2(c.getPhoto2())
                    .photo3(c.getPhoto3())
                    .location(c.getLocation())
                    .category(categoryService.findById(c.getCategory()).get())
                    .build();
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
                    .build();
        }
    }

