package com.equipe8.medsolution.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document("receituarios")
data class Receituario(
    @Id
    val _id: String? = UUID.randomUUID().toString(),
    val paciente: PacienteReceituario,
    val medico: MedicoReceituario,
    val medicamento: Any,
    val prescricao: String
)

data class MedicoReceituario(
    var nomeCompleto: String,
    val crm: String,
    val UF: String,
    val numero: String,
    var telefone: String,
    var cidade: String,
    val especialidade: String
)

data class PacienteReceituario(
    var nomeCompleto: String,
    val cpf: String,
    val endereco: String,
    val telefone: String,
    val email: String
)