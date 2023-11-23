package com.example.smartbusapi.controller;

import com.example.smartbusapi.model.Chats;
import com.example.smartbusapi.service.ChatsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class ChatsController {

    private final ChatsService chatsService;

    public ChatsController(ChatsService chatsService) {
        this.chatsService = chatsService;
    }

    @PostMapping("/create/chats")
    public String createChats(@RequestBody Chats chats) throws InterruptedException, ExecutionException {
        return chatsService.createChats(chats);
    }

    @GetMapping("/get/chats")
    public Chats getCity(@RequestParam String vehicleno) throws InterruptedException, ExecutionException {
        System.out.println("보낸 id : " + vehicleno);
        return chatsService.getChats(vehicleno);
    }

    @GetMapping("/get/chats/all")
    public List<Chats> getChatsList() throws InterruptedException, ExecutionException{
        return chatsService.getChatsList();
    }

    @PutMapping("/update/chats")
    public String updateCity(@RequestBody Chats chats) throws InterruptedException, ExecutionException{
        return chatsService.updateChats(chats);
    }

    @DeleteMapping("/delete/chats")
    public String deleteCity(@RequestParam String vehicleno) {
        return chatsService.deleteChats(vehicleno);
    }

}
