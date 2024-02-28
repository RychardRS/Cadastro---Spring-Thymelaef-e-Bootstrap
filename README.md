# Cadastro com Spring Thymelaef e Bootstrap
Este repositório irá conter um sistema de cadastro, desenvolvido com Spring, Thymelaef e Bootstrap.

- O sistema permite as seguintes funcionalidades:
1. Cadastrar uma pessoa
2. Listar todas as pessoas
3. Buscar pessoas
4. Deletar pessoas
5. Editar pessoas


- Como logar no sistema:
1. Crie uma conexão no seu Postgres chamada "postgres" (porta 5432) e senha "admin"
2. Dentro dessa conexão, crie um banco de dados chamado "postgres"
3. Após conectar ao banco de dados, execute seu backend para que as tabelas possam ser geradas
4. Com a tabelas geradas, vá até a tabela "usuario", lá irá aparecer campos como "id", "login" e "senha"
5. Insira o seu login que você deseja cadastrar diretamente no banco de dados
6. Para a senha, precisa criptografar antes de logar, para isso:
  - Você pode ir em DemoApplication e trocar o "123", pela senha que desejar, com isso será impresso a senha criptografada no console da IDE, basta colar essa senha criptografada no campo "senha" da tabela de "usuario"
OBS: Se colar a senha não criptografada, não irá funcionar.
7. Basta logar com as credenciais cadastradas
