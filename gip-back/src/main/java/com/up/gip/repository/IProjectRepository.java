package com.up.gip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.up.gip.entity.Project;

public interface IProjectRepository extends JpaRepository<Project, Integer>{

}
