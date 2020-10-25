package com.bruster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bruster.model.Nota;

public interface INotaRepo extends JpaRepository<Nota, Integer> {

}
