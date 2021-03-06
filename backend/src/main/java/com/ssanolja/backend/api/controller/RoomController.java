package com.ssanolja.backend.api.controller;


import com.ssanolja.backend.db.entity.Room;
import com.ssanolja.backend.api.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    @PostMapping("")
    public ResponseEntity<String> makeRoom() {
        return ResponseEntity.ok(roomService.makeRoomCode());
    }

    @GetMapping("/{roomCode}")
    public ResponseEntity joinRoom(@PathVariable String roomCode) {
        Optional<Room> room = roomService.findRoom(roomCode);
        if (room.isPresent()) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
