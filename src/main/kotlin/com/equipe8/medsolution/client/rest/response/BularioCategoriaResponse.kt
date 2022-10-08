package com.equipe8.medsolution.client.rest.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class BularioCategoriaResponse(
    val categorias: List<Categoria>
)

data class Categoria(
    val id: Int,
    val descricao: String,
    val ativo: String
)