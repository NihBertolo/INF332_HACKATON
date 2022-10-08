package com.equipe8.medsolution.controller

import com.equipe8.medsolution.controller.request.MedicoRequest
import com.equipe8.medsolution.controller.request.PacienteRequest
import com.equipe8.medsolution.model.Medico
import com.equipe8.medsolution.model.Paciente
import com.equipe8.medsolution.service.MedicoService
import com.equipe8.medsolution.service.PacienteService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/cadastros")
class CadastroController(
    private val medicoService: MedicoService,
    private val pacienteService: PacienteService
    ) {

    @PostMapping("/medicos")
    fun cadastrarMedico(medicoRequest: MedicoRequest): Medico {
        return this.medicoService.cadastrar(medicoRequest)
    }

    @PostMapping("/pacientes")
    fun cadastrarPaciente(pacienteRequest: PacienteRequest): Paciente {
        return this.pacienteService.cadastrar(pacienteRequest)
    }

    @GetMapping("/medicos")
    fun buscarMedicos(): ResponseEntity<List<Medico>> {
        return ResponseEntity.ok(this.medicoService.buscarTodos())
    }

    @GetMapping("/pacientes")
    fun buscarPacientes(): ResponseEntity<List<Paciente>> {
        return ResponseEntity.ok(this.pacienteService.buscarTodos())
    }

}