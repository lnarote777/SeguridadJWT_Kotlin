package com.es.jwtSecurityKotlin.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/secretos_extra_confidenciales")
class SecretosExtraConfidenciales {
    @GetMapping("/ficha1")
    fun getFichaUno () : String {
        return "Este recurso sólo puede ser accedido por usuarios registrados en la BDD \uD83E\uDD75"
    }

    @GetMapping("/ficha2")
    fun getFichaDos () : String {
        return "\uD83E\uDD75"
    }

}