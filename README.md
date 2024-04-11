#Mostrando endpoints expostos Swagger

http://localhost:8080/swagger-ui.html#/


#História

Iniciei  o projeto estruturando os pacotes para maior organização das classes;

Comecei pela entidade Car pois poderia fazer os relacionamentos com as outras entidades;

Adicionei o atributo "name" para a tabela Car para o usuário poder definir o nome do carro registrado;

Entendi que no JSON passado o modelo seria basicamente o nome do carro, fiz a alteração de poder registrar um carro com seu nome, ex: Creta,
um modelo, ex: SUV e a marca ex: Hyundai;

Adicionei o Swagger API para melhor visualização e verificação dos endpoints;

Comecei a criar uma classe para configuração do Cors mas estava dando conflito com o mapeamento do Swagger. Não sei ainda configurar corretamente, mas tentei construir algo
pesquisando. Estarei estudando mais sobre esse ponto. Comentei a classe para não afetar o Swagger que está funcionando corretamente;

Uitlizei da camada Service para a separar a lógica de negócio da controller;

Para conversão de dados, utilizei a dependência do mapstruct, aplicando suas devidas anotações
para estrutura de conversão, Dessa forma a lógica de conversão fica encapsulada, deixando o código mais limpo e legivel;

Criei a classe ValidateData para encapsular a lógica de métodos de validações utilizados para verificar ID's existentes no banco;

Decidi usar o Banco H2 para maior facilidade e praticidade;

Criei um data.sql file com dados pré inseridos na tabela Model e Brand para que consigam registrar carros e aplicarem o relacionamento com ID's de alguma Model e Brand,
portanto, ao rodar a aplicação automaticamente esses dados são lançados nas tabelas definidas.

A coluna REGISTER_AT está definida com um callback JPA, que faz parte do Spring Data JPA. Utilizei a anotação @PrePersist, que é usada para marcar um método que deve ser
executado antes de uma operação de persistência ser realizada. O método define a variavel "timeStampRegister" do tipo LocalDateTime.now() e a variavel sera preenchida
quando uma nova entidade for persistida pela primeira vez.





