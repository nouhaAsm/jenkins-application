package theme.park.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import theme.park.app.entity.ThemeParkRide;
import theme.park.app.repository.ThemeParkRideRepository;

@RestController
public class ThemeParkRideController {

    private ThemeParkRideRepository themeParkRideRepository;

    public ThemeParkRideController(ThemeParkRideRepository themeParkRideRepository) {
        this.themeParkRideRepository = themeParkRideRepository;
    }

    @GetMapping(value = "/ride")
    public Iterable<ThemeParkRide> getRides(){
        return themeParkRideRepository.findAll();
    }

    @GetMapping(value = "/ride/{id}")
    public ThemeParkRide getRide(@PathVariable long id){
        return themeParkRideRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid id %s",id)));
    }

    @PostMapping(value = "/ride")
    public ThemeParkRide creatRide(@RequestBody ThemeParkRide themeParkRide){
        return themeParkRideRepository.save(themeParkRide);
    }
}
