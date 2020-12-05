package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Usuario;

@Repository
public interface IUsuarioDAO extends JpaRepository<Usuario, Long> {

	public Usuario findByUsername(String username);
	
	
}
