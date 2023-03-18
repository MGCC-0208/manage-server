package com.example.canteen.service.impl;

import com.example.canteen.pojo.Users;
import com.example.canteen.repository.UserRepository;
import com.example.canteen.service.UserService;
import com.example.canteen.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Page<UserVO> findByNameLike (String username, Pageable pageable) {
        Page<Users> users = userRepository.findByNameLike(username, pageable);
        List<UserVO> list = new ArrayList<>();
        if (users != null && !users.isEmpty()) {
             list = users.stream().map(this::toVO).collect(Collectors.toList());
        }
        return new PageImpl<>(list, pageable, users.getTotalElements());
    }


    @Override
    public Page<UserVO> findAll(Pageable pageable) {
        Page<Users> users = userRepository.findAll(pageable);
        List<UserVO> list = new ArrayList<>();
        if (!users.isEmpty()) {
            list = users.stream().map(this::toVO).collect(Collectors.toList());
        }
        return new PageImpl<>(list, pageable, users.getTotalElements());
    }

    @Override
    public UserVO saveUser (UserVO user) {
        return toVO(userRepository.save(toPO(user)));
    }
    @Override
    public UserVO addUser (UserVO user) {
        Users users = new Users();
        users.setAddress(user.getAddress());
        users.setName(user.getName());
        users.setAge(user.getAge());
        users.setCities(user.getCities());
        users.setGender(user.getGender());
        users.setDetailedAddress(user.getDetailedAddress());
        users.setPhone(user.getPhone());
        return toVO(userRepository.save(users));
    }

    @Override
    public void deleteUser (Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public void batchDeleteUser (Integer[] ids) {
        userRepository.deleteAllById(Arrays.asList(ids));
    }


    public UserVO toVO(Users user){
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }

    public Users toPO(UserVO userVO) {
        Users users = new Users();
        BeanUtils.copyProperties(userVO, users);
        return users;
    }

}
