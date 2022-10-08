package com.equipe8.medsolution.repository

import com.equipe8.medsolution.model.Receituario
import org.springframework.data.mongodb.repository.MongoRepository

interface ReceituarioRepository: MongoRepository<Receituario, String> {
}