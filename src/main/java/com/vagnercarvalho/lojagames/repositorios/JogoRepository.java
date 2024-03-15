package com.vagnercarvalho.lojagames.repositorios;

import com.vagnercarvalho.lojagames.entidades.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository extends JpaRepository<Jogo, Long> {
}
