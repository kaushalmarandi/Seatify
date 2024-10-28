package m.kash.bookmyshowoct24.controllers;

import m.kash.bookmyshowoct24.dtos.ShowEntryDto;
import m.kash.bookmyshowoct24.dtos.ShowSeatEntryDto;
import m.kash.bookmyshowoct24.dtos.ShowTimingsDto;
import m.kash.bookmyshowoct24.services.ShowService;
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
}
