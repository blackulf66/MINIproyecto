package com.salesianostriana.dam.controladores;


import com.salesianostriana.dam.dto.POI.CreatePOIDto;
import com.salesianostriana.dam.dto.POI.GetPOIDto;
import com.salesianostriana.dam.dto.POI.POIDtoConverter;
import com.salesianostriana.dam.dto.category.CreateCategoryDto;
import com.salesianostriana.dam.dto.category.GetCategoryDto;
import com.salesianostriana.dam.modelo.Category;
import com.salesianostriana.dam.modelo.POI;
import com.salesianostriana.dam.servicios.CategoryService;
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
    private final CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<List<POI>> findAll(){
        return ResponseEntity.ok().body(poiService.findAll());
    }

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

    @PutMapping("/{id}")
    public ResponseEntity<POI> edit(@RequestBody @Valid CreatePOIDto c, @PathVariable Long id){
        return ResponseEntity.of(
                poiService.findById(id).map(a ->{
                    a.setName(c.getName());
                    a.setDescripcion(c.getDescripcion());
                    a.setCoverPhoto(c.getCoverPhoto());
                    a.setDate(c.getDate());
                    a.setCategory(categoryService.findById(c.getCategory()).get());
                    a.setLocation(c.getLocation());
                    a.setPhoto2(c.getPhoto2());
                    a.setPhoto3(c.getPhoto3());
                    return poiService.save(a);
                }) );

    }


}
