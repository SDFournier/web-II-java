package com.example.proyecto_manager.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.proyecto_manager.entities.Avatar;

@Repository("avatarRepository")
public interface IAvatarRepository extends 
						JpaRepository<Avatar, Serializable> {


	public abstract Avatar findById(int id);





}