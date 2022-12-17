package com.example.proyecto_manager.services;

import com.example.proyecto_manager.models.AvatarModelo;

import java.util.List;

import com.example.proyecto_manager.entities.Avatar;
public interface IAvatarService {


	public List<Avatar> getAll();

	public AvatarModelo insertOrUpdate(AvatarModelo avatarModelo);

	public boolean remove(int id);

}