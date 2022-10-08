package com.equipe8.medsolution.client.rest.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

@JsonIgnoreProperties(ignoreUnknown = true)
data class BularioResponse(
    @JsonProperty("content")
    val conteudo: List<Conteudo>?
)

data class Conteudo(
    val idProduto: Int,
    val numeroRegistro: String,
    val nomeProduto: String,
    val expediente: String,
    val razaoSocial: String,
    val cnpj: String,
    val numeroTransacao: String,
    val data: String,
    val numProcesso: String,
    val idBulaPacienteProtegido: String,
    val idBulaProfissionalProtegido: String,
    val dataAtualizacao: String
)
