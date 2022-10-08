package com.equipe8.medsolution.client.rest

import com.equipe8.medsolution.client.rest.response.BularioCategoriaResponse
import com.equipe8.medsolution.client.rest.response.BularioResponse
import com.equipe8.medsolution.client.rest.response.MedicamentoResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(value = "bulario", url = "\${rest-client.bulario.base-url}")
interface BularioClient {

    @RequestMapping(method = [RequestMethod.GET], value = ["\${rest-client.bulario.pesquisar-path}"])
    fun buscarMedicamento(@RequestParam("nome")nome: String): BularioResponse?

    @RequestMapping(method = [RequestMethod.GET], value = ["\${rest-client.bulario.categorias-path}"])
    fun buscarCategorias(): BularioCategoriaResponse?

    @RequestMapping(method = [RequestMethod.GET], value = ["\${rest-client.bulario.pesquisar-por-categoria-path}"])
    fun buscarMedicamentoPorCategoria(@RequestParam("categoria") categoria: Int): BularioResponse?

    @RequestMapping(method = [RequestMethod.GET], value = ["\${rest-client.bulario.pesquisar-medicamento}"])
    fun pesquisarMedicamento(@PathVariable("id") id: String): MedicamentoResponse?
}