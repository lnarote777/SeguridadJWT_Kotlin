package com.es.jwtSecurityKotlin.controller

import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/rutas_protegidas")
class RutaProtegidaController {


    @GetMapping("/recurso1")
    fun getRecursoProtegidoUno () : String {
        return "Este recurso sólo puede ser accedido por usuarios registrados en la BDD \uD83E\uDD75"
    }

    @PostMapping("/recurso2")
    fun isert(
        @RequestBody recurso : String
    ): String{
        return recurso
    }

    @GetMapping("/usuario_authenticado")
    fun saludarUsuarioAutenticado(authentication: Authentication): String {
        return "hola ${authentication.name}"
    }

    @DeleteMapping("/eliminar/{nombre}")
    fun eliminarUsuario (authentication: Authentication, @PathVariable nombre: String) : String {

        if (authentication.name == nombre){
            return "$nombre, ha sido eliminado por ti mismo ${authentication.name}"
        }

        if (authentication.authorities.any { rol -> rol.authority == "ROLE_ADMIN" }){
            return "$nombre, ha sido eliminado por ${authentication.name}"
        }
        return ""
    }

}