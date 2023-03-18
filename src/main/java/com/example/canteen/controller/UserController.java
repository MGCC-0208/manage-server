package com.example.canteen.controller;

import com.example.canteen.domain.Result;
import com.example.canteen.service.UserService;
import com.example.canteen.vo.UserVO;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public Result<List<UserVO>> getUsers(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                         @RequestParam(value = "size",defaultValue = "10") Integer size,
                                         @RequestParam(value = "username") String username) {
        Page<UserVO> users;
        Pageable pageable = PageRequest.of(page-1,size, Sort.Direction.DESC,"id");
        if (username.isEmpty()) {
            users = userService.findAll(pageable);
        } else {
            users = userService.findByNameLike(username, pageable);
        }
        return new Result<>(0, "success", users);

    }

    @PostMapping("/save")
    public Result saveUser(@Valid UserVO users) {
        if(userService.saveUser(users) != null) {
            return new Result(0, "success", null);
        } else {
            return new Result(1, "error",null);
        }

    }
    @PostMapping("/add")
    public Result addUser(@Valid UserVO users) {
        if(userService.addUser(users) != null) {
            return new Result(0, "success", null);
        } else {
            return new Result(1, "error",null);
        }
    }

    @GetMapping("/delete")
    public Result delete(@RequestParam("id") Integer id) {
        userService.deleteUser(id);
        return new Result(0, "success", null);
    }

    @GetMapping("/batchDelete")
    public Result batchDelete(Integer[] ids) {
        userService.batchDeleteUser(ids);
        return new Result(0, "success", null);
    }
}
