package com.equipe8.medsolution.controller

import com.equipe8.medsolution.client.rest.response.BularioCategoriaResponse
import com.equipe8.medsolution.client.rest.response.BularioResponse
import com.equipe8.medsolution.client.rest.response.MedicamentoResponse
import com.equipe8.medsolution.service.BularioService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/bularios")
class BularioController(private val bularioService: BularioService) {

    @GetMapping
    fun buscarMedicamento(@RequestParam("nome") nome: String): ResponseEntity<BularioResponse> {
        return ResponseEntity.ok(this.bularioService.buscarMedicamento(nome))
    }

    @GetMapping("/categorias")
    fun buscarCategorias(): ResponseEntity<BularioCategoriaResponse> {
        return ResponseEntity.ok(this.bularioService.buscarCategorias())
    }

    @GetMapping("/medicamentos")
    fun buscarMedicamentoPorCategoria(
        @RequestParam("categoria") categoria: Int
    ): ResponseEntity<BularioResponse> {
        return ResponseEntity.ok(this.bularioService.buscarMedicamentoPorCategoria(categoria))
    }

    @GetMapping("/medicamento")
    fun buscarMedicamentoPorProcesso(
        @RequestParam("processo") processo: String
    ): ResponseEntity<MedicamentoResponse> {
        return ResponseEntity.ok(this.bularioService.pesquisarMedicamentoPorProcesso(processo))
    }
}