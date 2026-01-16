package com.hackathon.churninsight.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.churninsight.api.domain.usuario.Usuario;
import com.hackathon.churninsight.api.domain.usuario.dto.DadosAutenticacaoDTO;
import com.hackathon.churninsight.api.domain.usuario.dto.DadosCadastroUsuarioDTO;
import com.hackathon.churninsight.api.domain.usuario.repository.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test") // Usa o application-test.properties com H2
class AutenticacaoControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Test
    @DisplayName("Deve cadastrar um usuário com sucesso quando os dados são válidos")
    void cadastrarCenario1() throws Exception {
        // ARRANGE
        String login = "teste-login";
        var dados = new DadosCadastroUsuarioDTO(login, "senha123");
        String json = objectMapper.writeValueAsString(dados);

        // ACT
        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("Usuário cadastrado com sucesso!"));

        // ASSERT (Verificando se realmente salvou no banco de dados)
        boolean usuarioExiste = usuarioRepository.existsByLogin(login);
        Assertions.assertTrue(usuarioExiste);
    }

    @Test
    @DisplayName("Deve retornar erro 422 quando o login já existe")
    void cadastrarCenario2() throws Exception {
        // ARRANGE
        String login = "teste-login-duplicado";
        var dados = new DadosCadastroUsuarioDTO(login, "senha123");
        String json = objectMapper.writeValueAsString(dados);

        // Simula o primeiro cadastro com sucesso
        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());

        // ACT & ASSERT (Tenta cadastrar o mesmo login novamente)
        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isUnprocessableEntity()); // Espera 422 Unprocessable Entity
    }

    @BeforeEach
    void setup() {
        usuarioRepository.deleteAll(); // Limpa o banco de dados antes de cada teste
        // Salva um usuário de teste com a senha criptografada
        Usuario usuario = new Usuario("teste-login-usuario", encoder.encode("senha123456"));
        usuarioRepository.save(usuario);
    }

    @Test
    @DisplayName("Deve retornar token JWT quando as credenciais estiverem corretas")
    void loginCenario1() throws Exception {
        // ARRANGE
        var dados = new DadosAutenticacaoDTO("teste-login-usuario", "senha123456");
        String json = objectMapper.writeValueAsString(dados);

        // ACT & ASSERT
        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").exists()); // Verifica se a chave "token" veio no JSON
    }

    @Test
    @DisplayName("Deve retornar 401 quando as credenciais forem inválidas")
    void loginCenario2() throws Exception {
        // ARRANGE (Senha errada)
        var dados = new DadosAutenticacaoDTO("teste-login-usuario", "senha-errada");
        String json = objectMapper.writeValueAsString(dados);

        // ACT & ASSERT
        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isUnauthorized()); // Espera 401 Unauthorized
    }
}
