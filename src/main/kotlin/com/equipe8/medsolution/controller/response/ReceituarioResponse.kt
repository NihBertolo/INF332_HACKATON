package com.equipe8.medsolution.controller.response

import com.equipe8.medsolution.client.rest.response.MedicamentoResponse
import com.equipe8.medsolution.model.Receituario

data class ReceituarioResponse(
    val emitente: Emitente,
    val paciente: PacienteResponse,
    val medicamento: MedicamentoResponse,
    val prescricao: String
) {
    companion object {
        fun toReceituarioResponse(
            receituario: Receituario
        ): ReceituarioResponse = ReceituarioResponse(
            emitente = Emitente(
                nomeCompleto = receituario.medico.nomeCompleto,
                crm = receituario.medico.crm,
                numero = receituario.medico.numero,
                UF = receituario.medico.UF,
                telefone = receituario.medico.telefone,
                cidade = receituario.medico.cidade
            ),
            paciente = PacienteResponse(
                nomeCompleto = receituario.paciente.nomeCompleto,
                endereco = receituario.paciente.endereco
            ),
            medicamento = receituario.medicamento as MedicamentoResponse,
            prescricao = receituario.prescricao
        )
    }
}

data class Emitente(
    val nomeCompleto: String,
    val crm: String,
    val numero: String,
    val UF: String,
    val telefone: String,
    val cidade: String
)

data class PacienteResponse(
    val nomeCompleto: String,
    val endereco: String
)
