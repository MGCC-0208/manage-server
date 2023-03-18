package com.example.canteen.repository;

import com.example.canteen.pojo.User;
import com.example.canteen.pojo.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {

    Users save(Users users);
    Page<Users> findByNameLike(String username, Pageable pageable);
}
