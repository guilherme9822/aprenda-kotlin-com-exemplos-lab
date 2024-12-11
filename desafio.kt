// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val email: String, val nivelDeExperiencia: Nivel)

data class ConteudoEducacional(
    val nome: String, 
    val duracao: Int = 60, 
    val nivel: Nivel = Nivel.BASICO
)

data class Formacao(
    val nome: String, 
    var conteudos: List<ConteudoEducacional>
) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        // Verifica se o usuário já está matriculado
        if (usuario !in inscritos) {
            inscritos.add(usuario)
            println("${usuario.nome} foi matriculado(a) no curso $nome.")
        } else {
            println("${usuario.nome} já está matriculado(a) neste curso.")
        }
    }
}

fun main() {
    // Criando usuários
    val usuario1 = Usuario("João", "joao@example.com", Nivel.BASICO)
    val usuario2 = Usuario("Maria", "maria@example.com", Nivel.INTERMEDIARIO)

    // Criando conteúdos
    val conteudo1 = ConteudoEducacional("Matemática Básica", 120, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Física Intermediária", 150, Nivel.INTERMEDIARIO)

    // Criando formação (curso)
    val formacao = Formacao("Curso de Ciências", listOf(conteudo1, conteudo2))

    // Matriculando usuários
    formacao.matricular(usuario1)  
    formacao.matricular(usuario2)  
    formacao.matricular(usuario1)  
}