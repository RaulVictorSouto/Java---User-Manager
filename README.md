Introdução

Segundo a documentação oficial da ferramenta (2024), o Primefaces trata-se de um framework de código aberto para desenvolvimento web utilizando a linguagem Java, com base na tecnologia JavaServer Faces (JSF). Conforme Félix (2024), o JSF é um framework Java destinado à construção de interfaces de usuário em aplicações web, por meio do uso de componentes reutilizáveis.
Deste modo, a fim de compreender os fundamentos de desenvolvimento web com Java, foi desenvolvido um sistema de cadastro de pessoas. Para isso, foram utilizadas as tecnologias Java, JSF, Primefaces, Tomcat e MySql.

Desenvolvimento

2.1 Desenvolvimento do banco de dados

O desenvolvimento do projeto iniciou-se por meio da criação do banco de dados “usuario”. Para isso, utilizou-se a linguagem SQL e o sistema de gerenciamento de banco de dados MySql Workbench. 
O banco de dados é constituído por uma única tabela, denominada "tblusuario". Esta tabela é composta pelas seguintes colunas: "id", com os atributos "int" e "primary key"; "nome", do tipo "varchar", com limite de até 30 caracteres; "senha", também do tipo "varchar", com limite de até 10 caracteres; "descricao", do tipo "varchar", permitindo até 50 caracteres; e "data_cadastro", do tipo "timestamp".

2.2 Configuração do projeto
	
Além da IDE Eclipse, foi utilizado o Apache Maven para maior praticidade. Conforme a biblioteca oficial da ferramenta (2024), ela tem a finalidade de gerenciamento e compressão de projetos de software. Esta tecnologia utiliza o arquivo XML, chamado de project object model (pom.xml), para descrição, organização das módulos externos e dependências do projeto.
Deste modo, o arquivo “pom.xml” foi configurado. As seguintes dependências foram adicionadas: “mariadb-java-client” e “mysql-connector-java”, para conexão com o banco de dados; “primefaces” e “javax.faces”, para implementação dos respectivos frameworks; “jakarta.enterprise.cdi-api” e “jakarta.inject-api” para injeção de dependências e ao gerenciamento de ciclos de vida de objetos em aplicações Java, conforme Barry (2024).
Após isso, foi configurado o arquivo “web.xml”. De acordo com a IBM (2024), este arquivo é necessário para gerenciar a apresentação de páginas e componentes web.

2.3 Desenvolvimento das classes

Com base no banco de dados criado, criou-se a classe “Usuario”, que está alocado no pacote “com.devmedia.model”. Destaca-se também a inclusão da biblioteca “java.util.Date” para representação de hora e data. Além disso, a classe possui métodos “get()” e “set()” para, respectivamente, retorno e definição de cada um dos atributos contidos na classe em questão. 
Também criou-se a classe “Connection”, responsável pela conexão com a base de dados. Deste modo, a classe contém os métodos “Connect()” para iniciar uma conexão com o banco de dados; “Close()”, para finalizar a conexão; “insertUsuario()”, para inserção de dados; e “listUsuarios()”, para resgate e exibição dos dados.
A classe “UsuarioManagedBean”, alocada no pacote “com.media.managedbeans”, é responsável pelo controle do cadastro e listagem de usuários, tendo em vista que as classes “ManageBean” têm a finalidade de conectar o código Java com a interface de usuário. Para isso é necessário o uso da notação “@ManagedBean”. Desta forma, está contida nesta classe os métodos “cadastraUsuario()”, para inserção de dados; “getUsuarios()” e “setUsuarios()”, para exibição das informações.
	
2.4 Criação das telas

A tela de cadastro foi configurada como tela inicial do sistema. Nela estão os seguintes componentes: panelgrid, para organização dos elementos em tabelas; spinner, para entrada de dados numéricos; inputTextarea e inputText, para entrada de dados alfanuméricos; commandButton, para execução da função de cadastro; e outputLabel, para exibição de textos.
A tela de listagem executa o método getUsuario() automaticamente. Para ela, foram utilizados o componente dataTable do Primefaces, para organização dos dados a serem exibidos em formato de tabela, além de headerText, para exibição do título das colunas, e outputText, para exibição do conteúdo.

Conclusão

O desenvolvimento deste projeto possibilitou o entendimento dos fundamentos de desenvolvimento web com a linguagem de programação Java.
A fim de realizar uma comparação com outros trabalhos, menciona-se o trabalho de Flores Jácome (2024). Trata-se do desenvolvimento de um sistema web para organização de ordens de serviço, utilizando as tecnologias de Java e Primefaces, por meio da arquitetura MVC e metodologias ágeis.
Por fim, destacam-se alguns desafios enfrentados durante o desenvolvimento do projeto, tais como problemas de importação das bibliotecas javax.faces, configuração do servidor Tomcat e importação do drive de conexão com o banco de dados. Estes problemas foram solucionados, respectivamente, por meio de tutorias presentes no fórum StackOverflow (2019), e os vídeos de Naveen (2023) e Coding Moments (2020).

Referências

APACHE Maven Project. Welcome to Apache Maven. 2024. Disponível em <https://maven.apache.org/>. Acesso em 05 de setembro de 2024.
BARRY, Douglas K. J2EE Web Server or Container. Service Architecture. 2024. Disponível em <https://www.service-architecture.com/articles/application-servers/j2ee-web-server-or-container.html>. Acesso em 05 de setembro de 2024.
CODING Moments. Not Suitable Driver Found for jdbc: mysql://localhost:3306?user=root&password=root. 2020. 6min41s. Disponível em <https://www.youtube.com/watch?v=vn1Y3VUNkAQ&t=304s>. Acesso em 05 de setembro de 2024.
FÉLIX, Milena. JSF: O que Você Precisa Saber para Começar. DIO.me. 2024. Disponível em <https://www.dio.me/articles/jsf-o-que-voce-precisa-saber-para-comecar>. Acesso em 05 de setembro de 2024.
FLORES JÁCOME, Jeremy Xavier. Implementación del módulo web “Ordenes de Trabajo” para la dirección de generación dentro del sistema integrado de Emelnorte (SIGEERN), conforme a la característica de usabilidad del estándar ISO/IEC 25010. 2024. Trabalho de Conclusão de Curso.
IBM. Arquivo web.xml. 2024. Disponível em <https://www.ibm.com/docs/pt-br/was/8.5.5?topic=SSEQTP_8.5.5/com.ibm.websphere.nd.multiplatform.doc/ae/rweb_webxf.htm>. Acesso em 05 de setembro de 2024.
NAVEEN, Badisa. The origin server did not find a current representation for the target resource or is not willing to. 2min37s. Disponível em <https://www.youtube.com/watch?v=rU7GhAFf52Y>. Acesso em 05 de setembro de 2024.
PRIME. Leading Provider of Open Source UI Component Libraries. Primefaces. 2024. Disponível em <https://www.primefaces.org/#>. Acesso em 05 de setembro de 2024.
STACKOVERFLOW. How to import javax.faces library in Eclipse using JDK8?. 2019. Disponível em <https://stackoverflow.com/questions/24468339/how-to-import-javax-faces-library-in-eclipse-using-jdk8>. Acesso em 05 de setembro de 2024.
