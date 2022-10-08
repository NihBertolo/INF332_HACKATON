package com.equipe8.medsolution.repository

import com.equipe8.medsolution.model.Paciente
import org.springframework.data.mongodb.repository.MongoRepository

interface PacienteRepository: MongoRepository<Paciente, String> {
}