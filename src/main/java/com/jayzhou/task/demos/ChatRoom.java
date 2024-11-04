package com.jayzhou.task.demos;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
@RestController
public class ChatRoom {

    private Map<String,Set<String>> room_user = new HashMap<>();

    @GetMapping("/joinRoom")
    public void joinRoom(@RequestParam String roomId, @RequestParam String userId){
        room_user.putIfAbsent(roomId, new HashSet<>());
        for (String otherUser : room_user.get(roomId)) {
            System.out.println("userId:" + otherUser + " in roomId:" + roomId);
        }
        room_user.get(roomId).add(userId);

    }

    @GetMapping("/leaveRoom")
    public void leaveRoom(@RequestParam String roomId, @RequestParam String userId){
        room_user.get(roomId).remove(userId);
        for (String otherUser : room_user.get(roomId)){
            System.out.println("userId:" + otherUser + "in  roomId:" + roomId);
        }
    }

}
