package br.com.msaorim.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.msaorim.cursomc.entities.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
