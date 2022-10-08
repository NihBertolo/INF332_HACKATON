package com.equipe8.medsolution.controller.request


data class PacienteRequest(
    val nomeCompleto: String,
    val cpf: String,
    val dataNascimento: String,
    val endereco: String,
    val uf: String,
    val telefone: String,
    val email: String
)
