package com.equipe8.medsolution.client.rest.response

data class MedicamentoResponse (
    val codigoProduto: Int,
    val tipoProduto: Int,
    val dataProduto: String,
    val nomeComercial: String,
    val classesTerapeuticas: Array<String>?,
    val numeroRegistro: String?,
    val dataVencimento: String?,
    val mesAnoVencimento: String?,
    val codigoParecerPublico: String?,
    val codigoBulaPaciente: String?,
    val codigoBulaProfissional: String?,
    val dataVencimentoRegistro: String?,
    val principioAtivo: String?,
    val medicamentoReferencia: String?,
    val categoriaRegulatoria: String?,
    val classeTerapeutica: Array<String>?,
    val atc: String?,
    val processosMedidaCautelar: Array<Any>?,
    val empresa: Empresa?,
    val processo: Processo?,
    val apresentacoes: Array<Any>?,
    val rotulos: Array<Any>?,
    val anexoRotulos: Array<Any>?,
)

data class Empresa (
    val cnpj: String,
    val razaoSocial: String,
    val numeroAutorizacao: String,
)
data class Processo (
    val numero: String,
    val situacao: Byte,
)
