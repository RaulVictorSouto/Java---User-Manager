Introdução

Com o objetivo de compreender os fundamentos de ORM (Object Relational Mapper), técnica destinada à relação de dados e objetos que estes representam, fez-se a reengenharia do projeto anteriormente desenvolvido. Para isso, utilizou-se o framework Hibernate. Também realizou-se algumas atualizações na base de dados para implementação de novos componentes do Primefaces.

Desenvolvimento

2.1 Atualização do banco de dados

Para maior eficácia na configuração do banco de dados, foram utilizados os recursos gráficos do MySql Workbench. A propriedade “AUTO_INCREMENT” foi adicionada ao atributo “id”. Segundo a documentação do MySql (2024), esta propriedade permite a inserção automática de um valor único à classe.
Também foram criadas duas colunas para a tabela, sendo elas, “data_nascimento”, do tipo Date, e “genero”, do tipo Enum. Ainda conforme a biblioteca do MySql (2024), o tipo Date permite a atribuição de datas à coluna em questão, enquanto o tipo Enum permite a inserção de strings previamente listadas, para a coluna “genero”, foram listadas as strings “Masculino”, “Feminino” e “Outro”.

2.2 Configuração e inserção de novos componentes
	
Para inserção dos novos componentes, criou-se novos atributos à classe Usuários, sendo eles “genero” e “dataNascimento”, ambos atributos privados, além de seus respectivos métodos Get() e Set().
	No arquivo “cadastro.xhmtl”, exclui-se o campo “id”, tendo em vista que esse é um atributo de complementação automática. Também alterou-se o tipo de input do campo de senha para “password” que, segundo a documentação do Primefaces (2024), possibilita a ocultação das informações digitadas. Os dados também foram adicionados no arquivo “listagem.xhtml”.
	Para os campos de data de nascimento e gênero usou-se, respectivamente, os componentes calendar e selectOneRadio. Ainda conforme a documentação do Primefaces (2024), o componente calendar possibilita a inserção de datas, enquanto o componente selectOneRadio permite a escolha de um único item dentre os listados.

Figura 3 - Tela de listagem

Fonte: Souto, Raul V. P. R.

2.3 Adição das dependências para uso do Hibernate

No arquivo “pom.xml”, foram adicionadas as dependências para utilização do Framework Hibernate. Segundo Zhang et. al. (2021), o Hibernate trata-se de um framework gratuito e de código aberto destinado ao mapeamento de objetos relacionais. O framework possui 5 interfaces principais, sendo elas: session, session factory, configuration, transaction e query.

2.4 Mapeamento da classe

A classe usuário foi transferida para o pacote Entify. Por meio da importação “jakarta.persistence.*”, as anotações JPA necessárias para definir a classe como uma entidade persistente foram adicionadas. 
Além disso, utilizou-se a notação “@Entify” para indicar que a classe usuário será mapeada. Também foi utilizada a anotação “@Table(name = "tblusuario")” para indicar em qual tabela do banco de dados os dados serão extraídos e armazenados. Para cada atributo, a anotação “@Column” foi utilizada para indicar sua respectiva coluna na tabela. Destaca-se também a utilização da notação “@Temporal” para captura de dados do tipo Date e Timestamp.


2.5 Configuração do Hibernate

Normalmente, para configuração do Hibernate, utiliza-se o arquivo hibernate.cfg.xml, presente no pasta resources do projeto. Em seguida, este arquivo é importado para o classe Hibernate Utility (HibernateUtil), responsável pelo auxílio no gerenciamento das interfaces do Hibernate, de acordo com Fatadare (2023).
	Devidos a problema com a importação do arquivo hibernate.cfg.xml, resultando na atribuição de valores nulos no interface session factory, as informações armazenadas nele foram adicionadas diretamente à classe HibernateUtil, conforme mostrado por Kayartaya (2020). Deste modo, por meio do objeto Properties, nativo do framework, as configurações relacionadas ao banco de dados foram incluídas. 


2.6 Configuração do Data Access Object

De acordo com a Oracle (2024), o padrão de Objeto de Acesso a Dados (DAO), possui a finalidade de proteção a substituição e modificação de dados de uma determinada base. 
O arquivo “UsuarioDAO”, presente no pacote “dao”, é responsável por acessar e manipular dados relacionados à entidade “Usuario” no seu banco de dados utilizando o Hibernate. Para isso, foram realizadas as importações das interfaces session, session factory, transaction e query do framework Hibernate. Além disso, o arquivo possui dois métodos: getUsuarios(), responsável por recuperar uma lista de usuários do banco de dados, e saveUsuario(), responsável por salvar um novo usuário no banco de dados.



2.7 Reengenharia do UsuarioManagedBean

Devido às alterações realizadas no projeto, o arquivo “UsuarioManagedBean”, controle do cadastro e listagem de usuários, foi alterado. Foi retirado do arquivo a lógica de persistência e demais operações de dados, pois agora estão presente em usuarioDAO, promovendo uma arquitetura mais limpa.

Conclusão

O desenvolvimento deste projeto possibilitou o entendimento dos fundamentos do framework Hibernate. 
Com o intuito de realizar uma comparação com outros estudos, faz-se referência ao sistema desenvolvido por Oliveira Neto (2022), o qual se trata de uma ferramenta destinada a auxiliar desenvolvedores a compreender e corrigir erros relacionados a exceções que possam surgir ao utilizar anotações do Hibernate. 

Referências

FATADARE, Ramesh. Hibernate 6 Example Tutorial. Java Guides. 2023. Disponível em <https://www.javaguides.net/2023/03/hibernate-6-example-tutorial.html> . Acesso em 12 de setembro de 2024.
KAYARTAYA, Vinod Kumar. 06 Creating the HibernateUtil class for getting a SessionFactory. Learn With Vinod. 8min06s. Disponível em <https://www.youtube.com/watch?v=kgRmiSlNIWs>. Acesso em 11 de setembro de 2024.
MYSQL. Date and Time Data Type Syntax. Oracle. 2024. Disponível em <https://dev.mysql.com/doc/refman/8.4/en/date-and-time-type-syntax.html>. Acesso em 10 de setembro de 2024.
MYSQL. 5.6.9 Using AUTO_INCREMENT. Oracle. 2024. Disponível em <https://dev.mysql.com/doc/refman/8.4/en/example-auto-increment.html>. Acesso em 10 de setembro de 2024.
MYSQL. 13.3.5 The ENUM Type. Oracle. 2024. Disponível em <https://dev.mysql.com/doc/refman/8.4/en/enum.html>. Acesso em 10 de setembro de 2024.
OLIVEIRA NETO, Carlos Antônio de. Hibersafe: um sistema de recomendação baseado no StackOverflow para Bugs do Hibernate relacionados a exceções. 2022. Dissertação de Mestrado. Universidade Federal do Rio Grande do Norte.
ORACLE. Data Access Object: Also Known As DAO. 2024. Disponível em <https://www.oracle.com/java/technologies/data-access-object.html>. Acesso em 12 de setembro de 2024.
PRIMEFACES. Password. PrimeTek. 2024. Disponível em <https://www.primefaces.org/showcase/ui/input/password.xhtml?jfwid=6b989>. Acesso em 12 de setembro de 2024.
PRIMEFACES. SelectOneRadio. PrimeTek. 2024. Disponível em <http://www.primefaces.org:8080/showcase/ui/input/oneRadio.xhtml?jfwid=0a4fc>. Acesso em 12 de setembro de 2024.
PRIMEFACES. Calendar (java.util.Date). PrimeTek. 2024. Disponível em <http://www.primefaces.org/showcase/ui/input/calendar/calendar.xhtml?jfwid=09c82>. Acesso em 12 de setembro de 2024.




