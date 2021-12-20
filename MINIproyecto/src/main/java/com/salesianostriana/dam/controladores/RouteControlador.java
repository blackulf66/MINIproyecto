package com.salesianostriana.dam.controladores;


import com.salesianostriana.dam.dto.POI.CreatePOIDto;
import com.salesianostriana.dam.dto.route.CreateRouteDto;
import com.salesianostriana.dam.dto.route.GetRouteDto;
import com.salesianostriana.dam.dto.route.RouteDtoConverter;
import com.salesianostriana.dam.modelo.POI;
import com.salesianostriana.dam.modelo.Route;
import com.salesianostriana.dam.servicios.POIService;
import com.salesianostriana.dam.servicios.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/route")
public class RouteControlador {

    private final RouteService routeService;
    private final RouteDtoConverter routeDtoConverter;
    private final POIService poiService;


    @GetMapping("/")
    public ResponseEntity<List<Route>> findAll(){
        return ResponseEntity.ok().body(routeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetRouteDto> findOne(@PathVariable Long id){
        return ResponseEntity.ok().body(routeDtoConverter.routeToGetrouteDto(routeService.findById(id).get()));
    }
    @PostMapping("/")
    public ResponseEntity<GetRouteDto> create(@Valid @RequestBody CreateRouteDto c){
        Route route = routeDtoConverter.createRouteDtoToRoute(c);
        routeService.save(route);
        GetRouteDto RouteDto = routeDtoConverter.routeToGetrouteDto(route);
        return ResponseEntity.status(HttpStatus.CREATED).body(RouteDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        routeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Route> edit(@RequestBody @Valid CreateRouteDto c, @PathVariable Long id){
        return ResponseEntity.of(
                routeService.findById(id).map(a ->{
                    a.setName(c.getName());
                    a.setSteps(c.getSteps());
                   return routeService.save(a);
                }) );

    }

    @PostMapping("/{id}/interes/{id2}")
    public ResponseEntity<GetRouteDto> addPoi(@Valid @PathVariable("id")Long id, @PathVariable("id2")Long id2){
        Route route = routeService.findById(id).get();
        POI poi= poiService.findById(id2).get();
        poi.addToRoute(route);
        poiService.save(poi);
        return ResponseEntity.ok().body(routeDtoConverter.routeToGetrouteDto(route));
    }

    @DeleteMapping("/{id}/interes/{id2}")
    public ResponseEntity<GetRouteDto> deletePoi(@Valid @PathVariable("id")Long id, @PathVariable("id2")Long id2){
        Route route = routeService.findById(id).get();
        POI poi= poiService.findById(id2).get();
        poi.removeFromRoute(route);
        poiService.save(poi);
        return ResponseEntity.ok().body(routeDtoConverter.routeToGetrouteDto(route));
    }
}
