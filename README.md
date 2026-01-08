# ChurnInsight API 🚀

A **ChurnInsight API** é uma solução robusta desenvolvida em **Spring Boot** para prever a rotatividade de clientes (Churn). Ela atua como uma ponte inteligente entre os dados brutos da empresa e um modelo de Dados externo, oferecendo autenticação segura, persistência em banco de dados e monitoramento de estatísticas.

## ✨ Funcionalidades

* **Autenticação JWT:** Sistema de login seguro com geração e validação de tokens Bearer.
* **Predição de Churn:** Integração via `RestTemplate` com modelo de Data Science para análise em tempo real.
* **Gestão de Clientes:** Cadastro e histórico de consultas com persistência no PostgreSQL.
* **Dashboard de Estatísticas:** Métricas de volume de consultas e taxa de churn acumulada.
* **Histórico de Consultas:** Endpoint paginado para auditoria de predições anteriores.
* **Tratamento de Erros:** Respostas padronizadas para exceções de validação, segurança e negócio.

## 🛠️ Tecnologias Utilizadas

* **Java 17** & **Spring Boot 3.5.8**
* **Spring Security** & **Auth0 JWT** (Segurança)
* **Spring Data JPA** & **PostgreSQL** (Persistência)
* **Lombok** (Produtividade)
* **SpringDoc OpenAPI (Swagger)** (Documentação)

---

## 📁 Estrutura do Projeto

O projeto segue uma estrutura organizada por domínios e camadas de infraestrutura:

```text
churninsight
├── src/main/java/com.hackathon.churninsight.api
│   ├── controller      # PredictController, StatsController, AutenticacaoController
│   ├── domain          # Entidades, DTOs e Repositories
│   │   ├── cliente     # Cliente, ClienteRequestDTO, Validacoes
│   │   ├── predicao    # Predicao, ResultadoPredicaoDTO, ListagemPredicaoDTO
│   │   └── usuario     # Usuario, DadosAutenticacaoDTO
│   ├── service         # Regras de negócio (PredicaoService, StatsService, Conversao)
│   └── infra           # Segurança, Exception Handler, Client HTTP (ModeloPythonClient)
└── src/main/resources
    ├── application.properties
    └── db.migration    # Scripts SQL (V1_create_table_clientes.sql)

Fluxo de Dados e Transformação (Data Mapping)
A API realiza a ponte entre o formato de negócio (String/Categorias) e o formato técnico exigido pelo modelo de Data Science (Numérico/Binário).

1. Entrada Back-End (ClienteRequestDTO)
O JSON enviado pelo usuário contém informações legíveis:

JSON

{  
"customerID": "7590-VHVEG",
"gender": "Female",
"SeniorCitizen": 0,
"Partner": "Yes",
"Dependents": "No",
"tenure": 1,
"PhoneService": "No",
"MultipleLines": "No phone service",
"InternetService": "DSL",
"OnlineSecurity": "No",
"OnlineBackup": "Yes",
"DeviceProtection": "No",
"TechSupport": "No",
"StreamingTV": "No",
"StreamingMovies": "No",
"Contract": "Month-to-month",
"PaperlessBilling": "Yes",
"PaymentMethod": "Electronic check",
"MonthlyCharges": 29.85,
"TotalCharges": 29.85
}

2. Transformação (ConversaoDadosService)
A aplicação converte categorias em variáveis dummy (binárias) para processamento da IA:

3. Requisição para API de Data Science (ModeloPythonClient)
O formato final enviado ao modelo de ML:

JSON

{
"tenure": 60,
"MonthlyCharges": 25.00,
"TotalCharges": 108.80,
"gender_Male": 1,
"Partner_Yes": 0,
"Dependents_Yes": 0,
"PhoneService_Yes": 1,
"MultipleLines_Yes": 0,
"InternetService_Fiber_optic": 0,
"InternetService_No": 0,
"OnlineSecurity_Yes": 1,
"OnlineBackup_Yes": 0,
"DeviceProtection_Yes": 0,
"TechSupport_Yes": 0,
"StreamingTV_Yes": 0,
"StreamingMovies_Yes": 0,
"Contract_One_year": 0,
"Contract_Two_year": 1,
"PaperlessBilling_Yes": 1,
"PaymentMethod_Credit_card_automatic": 0,
"PaymentMethod_Electronic_check": 1,
"PaymentMethod_Mailed_check": 0
}


## 🚀 Como Executar

Banco de Dados: Certifique-se de que o PostgreSQL está rodando e o banco churninsight_db foi criado.

## VARIAVEIS DE AMBIENTE BACK-END
* **URL EXEMPLO: url=jdbc:postgresql://${HOST:localhost}:${PORTA:5432}/${DB_NAME:churninsight_db}
* **LOGIN DO BANCO EXEMPLO: username=${DB_USER:postgres}
* **SENHA DO BANCO EXEMPLO: password=${DB_PASSWORD}
* **API CHAVE PARA CRIAÇÂO DO JWT. EXEMPLO: api.security.token.secret=${JWT_SECRET}

Variáveis de Ambiente: Configure as credenciais da API de Data Science:

URL_API_DS: URL do modelo Python.

USER_TOKEN: Token de autorização do modelo.

Build:

Bash

mvn clean install
Run:

Bash

mvn spring-boot:run
📖 Endpoints Principais

* **POST /auth/login: Obter token de acesso.

* **POST /api/predict: Realizar nova predição.

* **GET /api/consultas: Ver histórico paginado.

* **GET /api/stats: Ver métricas do dashboard.

* **GET /swagger-ui/index.html: Documentação completa.
