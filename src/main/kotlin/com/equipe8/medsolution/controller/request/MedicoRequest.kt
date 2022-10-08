package com.equipe8.medsolution.controller.request

import java.time.LocalDate

data class MedicoRequest(
    var nomeCompleto: String,
    val crm: String,
    val UF: String,
    val numero: String,
    var telefone: String,
    var cidade: String,
    val especialidade: String,
    val dataNascimento: String
)
