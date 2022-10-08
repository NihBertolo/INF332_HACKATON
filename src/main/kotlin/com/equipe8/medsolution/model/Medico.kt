package com.equipe8.medsolution.model

import org.springframework.data.annotation.Id

import java.time.LocalDate
import java.util.*

data class Medico(
    @Id
    val _id: String? = UUID.randomUUID().toString(),
    var nomeCompleto: String,
    val crm: String,
    val UF: String,
    val numero: String,
    var telefone: String,
    var cidade: String,
    val especialidade: String,
    val dataNascimento: LocalDate
)