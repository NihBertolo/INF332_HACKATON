package com.equipe8.medsolution.controller

import com.equipe8.medsolution.controller.request.ReceituarioRequest
import com.equipe8.medsolution.controller.response.ReceituarioResponse
import com.equipe8.medsolution.service.ReceituarioService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/receituarios")
data class ReceituarioController(private val receituarioService: ReceituarioService) {

    @GetMapping("/{id}")
    fun buscarReceituario(@PathVariable("id") id: String): ResponseEntity<ReceituarioResponse> {
        return ResponseEntity.ok(this.receituarioService.buscarReceituario(id))
    }

    @PostMapping
    fun criarReceituario(@RequestBody request: ReceituarioRequest): ResponseEntity<ReceituarioResponse> {
        return ResponseEntity(this.receituarioService.criarReceituario(request), HttpStatus.CREATED)
    }

    @GetMapping
    fun buscarReceituarios(): ResponseEntity<List<ReceituarioResponse>> {
        return ResponseEntity.ok(this.receituarioService.buscarReceituarios())
    }
}