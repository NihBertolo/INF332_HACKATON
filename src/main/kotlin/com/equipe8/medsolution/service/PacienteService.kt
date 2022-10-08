package com.equipe8.medsolution.service

import com.equipe8.medsolution.controller.request.PacienteRequest
import com.equipe8.medsolution.model.Paciente
import com.equipe8.medsolution.repository.PacienteRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class PacienteService(private val pacienteRepository: PacienteRepository) {


    fun buscarPorId(id: String): Paciente? {
        return this.pacienteRepository.findByIdOrNull(id)
    }

    fun cadastrar(pacienteRequest: PacienteRequest): Paciente {

        val paciente = Paciente(
            nomeCompleto = pacienteRequest.nomeCompleto,
            cpf = pacienteRequest.cpf,
            dataNascimento = LocalDate.parse(pacienteRequest.dataNascimento),
            endereco = pacienteRequest.endereco,
            uf = pacienteRequest.uf,
            telefone = pacienteRequest.telefone,
            email = pacienteRequest.email
        )
        return this.pacienteRepository.insert(paciente)
    }

    fun buscarTodos(): List<Paciente> {
        return this.pacienteRepository.findAll()
    }
}