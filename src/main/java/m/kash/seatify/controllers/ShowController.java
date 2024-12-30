package m.kash.seatify.controllers;

import m.kash.seatify.dtos.AllShowsOfMovieRequestDto;
import m.kash.seatify.dtos.ShowEntryDto;
import m.kash.seatify.dtos.ShowSeatEntryDto;
import m.kash.seatify.dtos.ShowTimingsDto;
import m.kash.seatify.models.Show;
import m.kash.seatify.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/addNew")
    public ResponseEntity<String> addShow(@RequestBody ShowEntryDto showEntryDto){
        try {
            String result = showService.addShow(showEntryDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/associateSeats")
    public ResponseEntity<String> associateShowSeats(@RequestBody ShowSeatEntryDto showSeatEntryDto){
        try {
            String result = showService.associateShowSeats(showSeatEntryDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/showTimingsOnDate")
    @ResponseBody
    public ResponseEntity<List<Time>>  showTimingsOnDate(@RequestBody ShowTimingsDto showTimingsDto){
        try{
            List<Time> result = new ArrayList<>();
                  result.addAll(showService.showTimingsOnDate(showTimingsDto));
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/getAllShowsOfMovie")
    public ResponseEntity<List<List<Show>>> allShowsOfMovie(@RequestBody AllShowsOfMovieRequestDto allShowsOfMovieRequestDto){
        try{
            List<List<Show>> result = new ArrayList<>();
            result=showService.allShowOfMovie(allShowsOfMovieRequestDto);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
