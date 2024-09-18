package br.elton.ifpi.gerenciadorUsuarios.Repository

import br.elton.ifpi.gerenciadorUsuarios.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario, Long> {

}