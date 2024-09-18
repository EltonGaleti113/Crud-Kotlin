package br.elton.ifpi.gerenciadorUsuarios.controller

import br.elton.ifpi.gerenciadorUsuarios.Repository.UsuarioRepository
import br.elton.ifpi.gerenciadorUsuarios.model.Usuario
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class UsuarioController {
    @Autowired
    lateinit var repositorio: UsuarioRepository

    @GetMapping("/formulario/cadastro")
    fun abrirFormularioCadastro(model: Model): String{

        val usuario: Usuario = Usuario()

        model.addAttribute("usuario", usuario)

        return "formulario-cadastro"
    }

    @PostMapping("/cadastrar")
    fun cadastrar(@Validated usuario: Usuario, result: BindingResult): String{

        if (result.hasErrors()){
            return "formulario-cadastro"
        }

        //printa as informaçoes recebidas pelo formulario
        println(usuario)
        repositorio.save(usuario)

        return "redirect:/"
    }
    @GetMapping("/")
    fun abrirHome(model: Model): String{
        //Busca Usuarios no BD
        val usuarios = repositorio.findAll()

        model.addAttribute("usuarios", usuarios)

        return "home"
    }
}