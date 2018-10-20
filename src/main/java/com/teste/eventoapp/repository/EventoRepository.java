package com.teste.eventoapp.repository;

import org.springframework.data.repository.CrudRepository;
import com.teste.eventoapp.models.Evento;

public interface EventoRepository extends CrudRepository<Evento, String> {


}
