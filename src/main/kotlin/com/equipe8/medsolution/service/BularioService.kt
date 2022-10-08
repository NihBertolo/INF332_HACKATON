package com.equipe8.medsolution.service

import com.equipe8.medsolution.client.rest.BularioClient
import com.equipe8.medsolution.client.rest.response.BularioCategoriaResponse
import com.equipe8.medsolution.client.rest.response.BularioResponse
import com.equipe8.medsolution.client.rest.response.MedicamentoResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class BularioService(private val bularioClient: BularioClient) {

    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    fun buscarMedicamento(nome: String): BularioResponse? {
        logger.info("[BularioService.buscarMedicamento] - ação: Iniciando busca por medicamento de nome: $nome")
        return this.bularioClient.buscarMedicamento(nome).also {
            logger.info("[BularioService.buscarMedicamento] - ação: busca por medicamento de nome: $nome " +
                    "concluída, total de elementos: ${it?.conteudo?.size}")
        }
    }

    fun buscarCategorias(): BularioCategoriaResponse? {
        logger.info("[BularioService.buscarCategorias] - ação: Iniciando busca de categorias")
        return this.bularioClient.buscarCategorias().also {
            logger.info("[BularioService.buscarCategorias] - ação: busca de categorias concluída, " +
                    "total de elementos: ${it?.categorias?.size}")
        }
    }

    fun buscarMedicamentoPorCategoria(categoria: Int): BularioResponse? {
        logger.info("[BularioService.buscarMedicamentoPorCategoria] - ação: Iniciando busca de medicamento por " +
                "categoria: $categoria")
        return this.bularioClient.buscarMedicamentoPorCategoria(categoria).also {
            logger.info("[BularioService.buscarMedicamentoPorCategoria] - ação: Busca de medicamento por " +
                    "categoria: $categoria concluída, total de elementosÇ ${it?.conteudo?.size}")
        }
    }

    fun pesquisarMedicamentoPorProcesso(idProcesso: String): MedicamentoResponse? {
        logger.info("[BularioService.pesquisarMedicamentoPorProcesso] - ação: Iniciando busca de medicamento por " +
                "processo: $idProcesso" )
        return this.bularioClient.pesquisarMedicamento(idProcesso).also {
            logger.info("[BularioService.pesquisarMedicamentoPorProcesso] - ação: Busca de medicamento por " +
                    "processo: $idProcesso concluída")
        }
    }


}