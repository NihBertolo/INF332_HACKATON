package com.equipe8.medsolution.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.util.*

@Document("pacientes")
data class Paciente(
    @Id
    val _id: String? = UUID.randomUUID().toString(),
    val nomeCompleto: String,
    val cpf: String,
    val dataNascimento: LocalDate,
    val endereco: String,
    val uf: String,
    val telefone: String,
    val email: String
)