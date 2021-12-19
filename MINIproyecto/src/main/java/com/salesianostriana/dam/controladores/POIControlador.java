package com.salesianostriana.dam.controladores;


import com.salesianostriana.dam.dto.POI.CreatePOIDto;
import com.salesianostriana.dam.dto.POI.GetPOIDto;
import com.salesianostriana.dam.dto.POI.POIDtoConverter;
import com.salesianostriana.dam.dto.category.CreateCategoryDto;
import com.salesianostriana.dam.dto.category.GetCategoryDto;
import com.salesianostriana.dam.modelo.Category;
import com.salesianostriana.dam.modelo.POI;
import com.salesianostriana.dam.servicios.POIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/poi")
public class POIControlador {

    private final POIService poiService;
    private final POIDtoConverter poiDtoConverter;

    @GetMapping("/")
    public ResponseEntity<List<POI>> findAll(){ return ResponseEntity.ok().body(poiService.findAll());}

    @GetMapping("/{id}")
    public ResponseEntity<GetPOIDto> findOne(@PathVariable Long id){
        return ResponseEntity.ok().body(poiDtoConverter.POIToGetPOIDto(poiService.findById(id).get()));
    }
    @PostMapping("/")
    public ResponseEntity<GetPOIDto> create(@Valid @RequestBody CreatePOIDto c){
        POI POI = poiDtoConverter.createPOIDtoToPOI(c);
        poiService.save(POI);
        GetPOIDto POIDto = poiDtoConverter.POIToGetPOIDto(POI);
        return ResponseEntity.status(HttpStatus.CREATED).body(POIDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        poiService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
