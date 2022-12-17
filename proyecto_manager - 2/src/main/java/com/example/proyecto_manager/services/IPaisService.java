package com.example.proyecto_manager.services;

import com.example.proyecto_manager.models.PaisModelo;

import java.util.List;

import com.example.proyecto_manager.entities.Pais;

public interface IPaisService {


	public List<Pais> getAll();

	public PaisModelo insertOrUpdate(PaisModelo paisModelo);

	public boolean remove(int id);

	public PaisModelo traerPorId(int id);

	public List<PaisModelo> getAllModel();

}