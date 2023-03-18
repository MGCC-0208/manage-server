package com.example.canteen.service;

import com.example.canteen.form.UserForm;
import com.example.canteen.pojo.User;
import com.example.canteen.vo.UserVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserService {


    Page<UserVO> findByNameLike(String username, Pageable pageable);

    Page<UserVO> findAll(Pageable pageable);

    UserVO saveUser(UserVO user);
    UserVO addUser(UserVO user);

    void deleteUser(Integer id);
    void batchDeleteUser(Integer[] id);


}
