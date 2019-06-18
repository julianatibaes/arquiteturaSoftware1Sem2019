package com.up.gip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.up.gip.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer>{

}
