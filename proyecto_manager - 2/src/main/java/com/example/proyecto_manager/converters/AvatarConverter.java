package com.example.proyecto_manager.converters;

import org.springframework.stereotype.Component;
import com.example.proyecto_manager.entities.Avatar;
import com.example.proyecto_manager.models.AvatarModelo;

@Component("avatarConverter")
public class AvatarConverter {

	public AvatarModelo entityToModel(Avatar avatar) {

		return new AvatarModelo(avatar.getId(), avatar.getEmail(),avatar.getWebPersonal(),avatar.getImagen());

	}



	public Avatar modelToEntity(AvatarModelo avatarModelo) {

		return new Avatar(avatarModelo.getId(), avatarModelo.getEmail(), avatarModelo.getWebPersonal(),avatarModelo.getImagen());


	}

}