package com.equipe8.medsolution.repository

import com.equipe8.medsolution.model.Medico
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface MedicoRepository: MongoRepository<Medico, String> {

    @Query("{crm:'?0'}")
    fun findMedicoByCrm(crm: String): Medico
}