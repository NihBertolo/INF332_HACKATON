package com.equipe8.medsolution.service

import com.equipe8.medsolution.controller.request.MedicoRequest
import com.equipe8.medsolution.model.Medico
import com.equipe8.medsolution.repository.MedicoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class MedicoService(private val medicoRepository: MedicoRepository) {

    fun buscarPorId(id: String): Medico? {
        return this.medicoRepository.findByIdOrNull(id)
    }

    fun cadastrar(medicoRequest: MedicoRequest): Medico {

        val medico = Medico(
            nomeCompleto = medicoRequest.nomeCompleto,
            crm = medicoRequest.crm,
            UF = medicoRequest.UF,
            numero = medicoRequest.numero,
            telefone = medicoRequest.telefone,
            cidade = medicoRequest.cidade,
            especialidade = medicoRequest.especialidade,
            dataNascimento = LocalDate.parse(medicoRequest.dataNascimento)
        )

        return this.medicoRepository.insert(medico)
    }

    fun buscarTodos(): List<Medico> {
        return this.medicoRepository.findAll()
    }
}