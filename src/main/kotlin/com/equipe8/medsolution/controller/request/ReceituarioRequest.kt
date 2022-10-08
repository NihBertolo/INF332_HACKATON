package com.equipe8.medsolution.controller.request

data class ReceituarioRequest(
    val medicoId: String,
    val pacienteId: String,
    val prescricao: String,
    val numeroProcesso: String
)