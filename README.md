## AImpress

## Integrantes e suas materias

RM97887 - João Carlos França Figueiredo - Disruptive Architectures: IOT, IOB & Generative AI

RM550200 - Leonardo Oliveira Esparza - Mobile App Development e Java Advanced.

RM552421 - Flavio Sousa Vasconcelos - Mastering Relational and Non-Relational Database e Devops Tools e Cloud Computing.

RM552368 - Wellington de Oliveira Urcino Da Silva - Advanced Business Development With .NET e Compliance & Quality Assurance.

# Resumo

Este chatbot de criação de currículos profissionais é uma ferramenta inovadora projetada para simplificar e aprimorar o processo de elaboração de currículos em um mundo competitivo. Destacando-se pela qualidade garantida através da análise de currículos de alta visibilidade, utiliza algoritmos avançados para identificar as melhores práticas e tendências do mercado. Sua integração com o LinkedIn permite acesso rápido às informações do perfil do usuário, incorporando-as automaticamente ao currículo em construção. Além da formatação em PDF para distribuição e impressão, oferece sugestões personalizadas com base em uma vasta base de dados, visando tornar o currículo mais atrativo e eficaz. Em suma, é uma ferramenta poderosa para quem busca se destacar no mercado de trabalho, oferecendo uma maneira eficiente e confiável de produzir currículos adaptados às demandas do mundo corporativo contemporâneo.



# Diagram de Entidade e Relacionamento
  
![image](https://github.com/EsparzaPhoenix/Sprint2AImpress/assets/92988596/a8aa765c-60a2-4a79-9153-e1eda22a8f12)


# Vídeo apresentando a Proposta Tecnológica

  [Vídeo Pitch](https://youtu.be/mSfu-ns4Kco)

# Link do Swagger

  [Swagger](http://localhost:8080/swagger-ui/index.html)

# Instrução de como rodar a aplicação
*    Clique no botão CODE destacado em verde e faça o download do arquivo ZIP da aplicação.
*    Descompacte o arquivo e abra o projeto em uma IDE, de preferência o Intellij.
*    As dependências serão automaticamente baixadas pelo Maven.
*    Inicie a aplicação clicando no botão play no topo da IDE.
*    Abra a aplicação de testes de API (Insomnia, Postman) disponível em seu computador.
*    Na barra de endereço, coloque a URL "http://localhost:8080/" e adicione o endpoint escolhido para teste, de acordo com a documentação.

# Listagem de todos os endpoints

POST: Cadastrar um novo currículo:

    URL: http://localhost:8080/usuarios
    Método HTTP: POST
    JSON de exemplo:

    json

    {
        "nome": "João da Silva",
        "numeroTelefone": "11936620738",
        "resumo": "Profissional com experiência na área de desenvolvimento de software...",
        "experiencia": "Desenvolvedor de software na Empresa X por 3 anos...",
        "nivelEscolaridade": "SUPERIOR",
        "carreira": "DESENVOLVEDOR",
        "cursos": "Curso de Java Avançado, Curso de Angular, Curso de Git e GitHub",
        "idiomas": "Inglês fluente, Espanhol básico"
    }

GET: Obter um currículo por ID:

    URL: http://localhost:8080/curriculos/{id}
    Método HTTP: GET


DELETE: Deletar um currículo por ID:

    URL: http://localhost:8080/curriculos/{id}
    Método HTTP: DELETE
    Não é necessário enviar um JSON, apenas o ID do currículo a ser deletado.

PUT: Atualizar um currículo por ID:

    URL: http://localhost:8080/curriculos/{id}
    Método HTTP: PUT
    JSON de exemplo:

    json

    {
        "nome": "João da Silva",
        "numeroTelefone": "11936620738",
        "resumo": "Profissional com experiência na área de desenvolvimento de software...",
        "experiencia": "Desenvolvedor de software na Empresa X por 3 anos...",
        "nivelEscolaridade": "SUPERIOR",
        "carreira": "DESENVOLVEDOR",
        "cursos": "Curso de Java Avançado, Curso de Angular, Curso de Git e GitHub",
        "idiomas": "Inglês fluente, Espanhol básico"
    }

POST: Cadastrar um novo usuario:

    URL: http://localhost:8080/usuarios
    Método HTTP: POST
    JSON de exemplo:

    json

    {
        "name":"Kleber Jorge",
        "email":"banana@gmail.com",
        "dataNascimento": "1990-05-21"
    }

GET: Obter um usuario por ID:

    URL: http://localhost:8080/usuarios/{id}
    Método HTTP: GET    

DELETE: Deletar um usuario por ID:

    URL: http://localhost:8080/usuarios/{id}
    Método HTTP: DELETE
    Não é necessário enviar um JSON, apenas o ID a ser deletado.

PUT: Atualizar um usuario por ID:

    URL: http://localhost:8080/usuarios/{id}
    Método HTTP: PUT
    JSON de exemplo:

    json

    {
        "name":"Kleber Jorge",
        "email":"banana@gmail.com",
        "dataNascimento": "1990-05-21"
    }

POST: Cadastrar uma nova empresa:

    URL: http://localhost:8080/empresas
    Método HTTP: POST
    JSON de exemplo:

    json

    {
        "nome": "Empresa ABC",
        "descricao": "Uma empresa de exemplo"
    }

GET: Obter um empresa por ID:

    URL: http://localhost:8080/empresas/{id}
    Método HTTP: GET    

DELETE: Deletar um empresa por ID:

    URL: http://localhost:8080/empresas/{id}
    Método HTTP: DELETE
    Não é necessário enviar um JSON, apenas o ID a ser deletado.

PUT: Atualizar um empresa por ID:

    URL: http://localhost:8080/empresas/{id}
    Método HTTP: PUT
    JSON de exemplo:

    json

    {
        "nome": "Empresa ABC",
        "descricao": "Uma empresa de exemplo"
    }

POST: Cadastrar uma nova vaga:

    URL: http://localhost:8080/vagas
    Método HTTP: POST
    JSON de exemplo:

    json

    {
        "titulo": "Desenvolvedor Java",
        "descricao": "Descrição da vaga de desenvolvedor Java.",
        "requisitos": "Experiência com Java, Spring Boot, etc.",
    }

GET: Obter uma vaga por ID:

    URL: http://localhost:8080/vagas/{id}
    Método HTTP: GET    

DELETE: Deletar uma vaga por ID:

    URL: http://localhost:8080/vagas/{id}
    Método HTTP: DELETE
    Não é necessário enviar um JSON, apenas o ID a ser deletado.

PUT: Atualizar uma vaga por ID:

    URL: http://localhost:8080/vafas/{id}
    Método HTTP: PUT
    JSON de exemplo:

    json

    {
        "titulo": "Desenvolvedor Java",
        "descricao": "Descrição da vaga de desenvolvedor Java.",
        "requisitos": "Experiência com Java, Spring Boot, etc.",
    }

