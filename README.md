Setor empresarial

Serviços e Assinaturas (Telecomunicações, Fintech, Streaming, Comércio Eletrônico)

Empresas que dependem de clientes recorrentes e desejam reduzir cancelamentos ou desistências.

Descrição do projeto

O desafio da ChurnInsight é criar uma solução que impeça um cliente de cancelar um serviço (churn).

O objetivo é que a equipe de Ciência de Dados desenvolva um modelo preditivo e que a equipe de Back-end construa uma API para disponibilizar essa previsão a outros sistemas, permitindo que a empresa tome uma decisão antes que o cliente decida cancelar o serviço.

Exemplo: uma fintech quer saber, com base nos hábitos de uso e histórico de pagamentos, quais clientes têm alta probabilidade de inadimplência. Com essas informações, a equipe de marketing pode oferecer serviços personalizados e a equipe de suporte pode ser acionada preventivamente.

Necessidades do cliente (explicação não técnica)

Qualquer empresa que venda por contrato ou contrato recorrente está sujeita a cancelamentos. Manter clientes fiéis é mais barato do que conquistar novos.

O cliente (empresa) quer prever com antecedência a possibilidade de cancelamento, para poder realocar e dispensar essas pessoas.

A solução esperada deve ajudar:

Identificar clientes com risco de cancelamento (churn);

Priorizar ações de retenção (ofertas, contatos, bônus);

Medir o impacto dessas ações ao longo do tempo.

Validação de mercado

Antecipar a rotatividade de clientes é uma das aplicações mais comuns e valiosas da análise de dados nos negócios modernos.

Empresas de telecomunicações, bancos digitais, instituições de ensino, plataformas de streaming e fornecedores de software utilizam modelos de churn para:

reduzir perdas financeiras;

Compreender os padrões de comportamento do cliente;

Aumentar o ritmo médio do relacionamento (valor vitalício).

Mesmo modelos simples podem ser valiosos, ajudando as empresas a direcionar seus esforços para os locais com maior risco de perda.

Expectativas para este hackathon

Público-alvo: estudantes iniciantes em tecnologia, sem experiência profissional na área, mas que não estudaram Back-end com Java (APIs REST, persistência, testes) e Ciência de Dados (Python, Pandas, scikit-learn, aprendizado de máquina supervisionado).

Objetivo: construir, em grupo, um MVP (produto mínimo viável) capaz de prever se um cliente cancelará o serviço e disponibilizar essa previsão por meio de uma API funcional .

Âmbito ideal: Classificação binária (“Vou cancelar” / “Vou continuar”) com base em um conjunto de dados pequeno e limpo.

Entregas desejadas

Notebook (Jupyter/Colab) para tempo de Ciência de Dados, conteúdo:

Exploração e limpeza de dados (EDA);

Engenharia de funcionalidades (ex.: tempo de utilização, frequência de login, histórico de pagamentos);

Treinamento supervisionado de modelos (ex.: Regressão Logística, Floresta Aleatória);

Métricas de desempenho (Precisão, Exatidão, Recall, Pontuação F1);

Serialização do modelo (joblib/pickle).

Aplicação Back-End em Java (API REST)

Ponto de extremidade que recebe informações de um cliente e retorna ao modelo anterior (Ex.: “Vai cancelar” / “Vai continuar”);

Integração com o modelo DS (diretamente ou via microsserviço Python);

Registros e tratamento de erros.

Documentação mínima (README):

Como executar o modelo de API EA;

Exemplos de requisição e resposta (JSON);

Dependências e variantes das ferramentas.

Demonstração funcional (Apresentação curta):

Demonstrar a API em ação (via Postman, cURL ou interface simples);

Explique como o modelo realiza verificações prévias.

Funcionalidades necessárias (MVP)

O serviço deve ser exportado por um endpoint que retorne uma previsão para o cliente com uma probabilidade associada a essa previsão. Exemplo: POST /predict: recebe JSON com dados do cliente e retorna: { "previsao": "Vai cancel", "probabilite": 0.76 }

Carregamento do modelo preditivo: o back-end deve ser capaz de acessar o modelo de churn (localmente ou via serviço DS).

Validação de entrada: verifique se todos os campos obrigatórios estão preenchidos previamente.

Resposta estruturada: inclui previsão e probabilidade numérica.

Exemplos de uso: 3 requisitos de teste (clientes sem cancelamento).

Documentação simples: um arquivo README explicando como executar o projeto e reproduzir os testes.

Recursos opcionais

Endpoint GET /stats: retorna estatísticas básicas, como: { "total_validated": 500, "taxa_churn": 0.23 }

Persistência de previsão: armazenar clientes e resultados no banco de dados (H2 ou PostgreSQL).

Painel de controle simples (Streamlit ou HTML): visualize os clientes com maior visibilidade.

Explicabilidade básica: incluir a não resposta das 3 variáveis ​​mais relevantes para o resultado (ex.: “período contratual”, “atrasos nos pagamentos”, “uso do aplicativo”).

Previsão em lote: endpoint que compila a lista de clientes (arquivo CSV).

Containerização: construa o sistema completo com Docker/Docker Compose.

Testes automatizados: testes unitários e de integração simples (JUnit, pytest).

Orientações técnicas para estudantes

Controle o volume de dados ao usar a OCI, levando em consideração a quantidade de memória que a OCI suporta, e cuidando dos dados utilizados para não ultrapassar o limite da camada gratuita da OCI.

Hora da Ciência de Dados:

Crie seu próprio conjunto de dados com informações do cliente (exemplo: período do contrato, atrasos nos pagamentos, utilização do serviço, tipo de plano, etc.).

Utilize Python, Pandas e scikit-learn para analisar os modelos.

Escolha modelos de classificação simples (Regressão Logística, Floresta Aleatória);

Crie funcionalidades intuitivas (ex.: tempo de permanência do cliente, número de compras recentes, despesas médias);

Salve o modelo e o pipeline (joblib.dump) e certifique-se de que ele possa ser carregado no notebook.

Tempo de back-end:

Criar uma API REST (Java + Spring Boot);

Receber JSON com dados do cliente e retornar à pré-visualização;

Conecte-se ao modelo DS:

via microsserviço Python (FastAPI/Flask), ou

Carregando o modelo exportado no formato ONNX (opção mais avançada);

Valide as entradas e retorne erros claros quando faltarem informações.

Contrato de integração (JSON)

Recomendamos definir o logotipo do contrato de integração no início do hackathon. Veja um exemplo:

Entrada:

{

"tempo_contrato_meses": 12,

"atrasos_de_pagamento": 2,

"uso mensal": 14,5,

"plano": "Premium"

}

Saída:

{

"previsao": "Vai cancelar",

"Probabilidade": 0,81

}
