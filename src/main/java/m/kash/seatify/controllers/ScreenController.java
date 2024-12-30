package m.kash.seatify.controllers;

import m.kash.seatify.dtos.ScreenEntryDto;
import m.kash.seatify.dtos.ScreenSeatEntryDto;
import m.kash.seatify.services.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/screen")
public class ScreenController {

        @Autowired
        private ScreenService screenService;

        @PostMapping("/addNew")
        public ResponseEntity<String> addScreen(@RequestBody ScreenEntryDto screenEntryDto){
            try{
                String result = screenService.addScreen(screenEntryDto);
                return new ResponseEntity<>(result, HttpStatus.CREATED);
            } catch (Exception e){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        }

        @PostMapping("/addScreenSeat")
        public ResponseEntity<String> addScreenSeat(@RequestBody ScreenSeatEntryDto screenSeatEntryDto){
            try {
                String result = screenService.addScreenSeat(screenSeatEntryDto);
                return new ResponseEntity<>(result, HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        }
}


