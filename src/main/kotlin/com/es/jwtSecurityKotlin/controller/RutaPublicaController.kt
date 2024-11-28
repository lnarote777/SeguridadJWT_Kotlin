package com.es.jwtSecurityKotlin.controller

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/rutas_publicas")
class RutaPublicaController {


    @GetMapping("/recurso1")
    fun getRecursoPublicoUno () : String {
        return "Este recurso puede ser accedido por cualquiera, es público \uD83D\uDE0E"
    }

    @PostMapping("/recurso3")
    fun insert(
        @RequestBody recurso : String
    ): String{
        return recurso
    }


}