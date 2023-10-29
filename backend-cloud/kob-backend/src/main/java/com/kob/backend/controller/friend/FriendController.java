package com.kob.backend.controller.friend;


import com.kob.backend.common.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/friend")
public class FriendController {

    @GetMapping("/verification")
    public Result<?> sendFriendVerification(){
        return null;
    }

    @PostMapping
    public Result<?> handleFriendRequest(){
        return null;
    }

    @DeleteMapping
    public Result<?> deleteFriend(){
        return null;
    }

    @GetMapping
    public Result<?> getFriendList(){
        return null;
    }
}
