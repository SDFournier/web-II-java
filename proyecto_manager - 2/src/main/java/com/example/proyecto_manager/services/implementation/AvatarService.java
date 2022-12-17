package com.example.proyecto_manager.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.proyecto_manager.converters.AvatarConverter;
import com.example.proyecto_manager.converters.TaskConverter;
import com.example.proyecto_manager.entities.Avatar;
import com.example.proyecto_manager.entities.Task;
import com.example.proyecto_manager.models.AvatarModelo;
import com.example.proyecto_manager.models.TaskModelo;
import com.example.proyecto_manager.repositories.IAvatarRepository;
import com.example.proyecto_manager.repositories.ITaskRepository;
import com.example.proyecto_manager.services.IAvatarService;
import com.example.proyecto_manager.services.ITaskService;


@Service("avatarService")
public class AvatarService implements IAvatarService {

	@Autowired
	@Qualifier("avatarRepository")
	private IAvatarRepository avatarRepository;

	@Autowired
	@Qualifier("avatarConverter")
	private AvatarConverter avatarConverter;

	@Override
	public List<Avatar> getAll(){	
		return avatarRepository.findAll();	
	}

	@Override
	public AvatarModelo insertOrUpdate(AvatarModelo avatarModelo) {

		Avatar avatar = avatarRepository.save(avatarConverter.modelToEntity(avatarModelo));

		return avatarConverter.entityToModel(avatar);
	}

	@Override
	public boolean remove(int id) {

		try {
			avatarRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}

	}


}