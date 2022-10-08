package com.equipe8.medsolution.service

import com.equipe8.medsolution.controller.request.ReceituarioRequest
import com.equipe8.medsolution.controller.response.ReceituarioResponse
import com.equipe8.medsolution.controller.response.ReceituarioResponse.Companion.toReceituarioResponse
import com.equipe8.medsolution.model.MedicoReceituario
import com.equipe8.medsolution.model.PacienteReceituario
import com.equipe8.medsolution.model.Receituario
import com.equipe8.medsolution.repository.ReceituarioRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ReceituarioService(
    private val receituarioRepository: ReceituarioRepository,
    private val bularioService: BularioService,
    private val pacienteService: PacienteService,
    private val medicoService: MedicoService
    ) {

    fun buscarReceituario(id: String): ReceituarioResponse? {
        return toReceituarioResponse(this.receituarioRepository.findByIdOrNull(id)!!)
    }

    fun criarReceituario(request: ReceituarioRequest): ReceituarioResponse {
        val medico = this.medicoService.buscarPorId(request.medicoId)
        val paciente = this.pacienteService.buscarPorId(request.pacienteId)
        val medicamento = this.bularioService.pesquisarMedicamentoPorProcesso(request.numeroProcesso)

        val receituario = Receituario(
            paciente = PacienteReceituario(
                nomeCompleto = paciente!!.nomeCompleto,
                cpf = paciente.cpf,
                endereco = paciente.endereco,
                telefone = paciente.telefone,
                email = paciente.email
            ),
            medico = MedicoReceituario(
                nomeCompleto = medico!!.nomeCompleto,
                crm = medico.crm,
                UF = medico.UF,
                numero = medico.numero,
                telefone = medico.telefone,
                cidade = medico.cidade,
                especialidade = medico.especialidade
            ),
            medicamento = medicamento!!,
            prescricao = request.prescricao
        )
        return toReceituarioResponse(this.receituarioRepository.insert(receituario))
    }

    fun buscarReceituarios(): List<ReceituarioResponse>? {
        return this.receituarioRepository.findAll().map { toReceituarioResponse(it) }
    }
}