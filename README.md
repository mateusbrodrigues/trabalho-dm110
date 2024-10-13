# DM110 Java EE

## Entidade Utilizada

**Customer**: 
- CPF
- Nome
- Data de Nascimento
- Gênero
- Email
- CEP

## Ferramentas Utilizadas

- JDK 17
- Wildfly (versão usada: 33)
- Maven
- JBoss
- HSQLDB (versão usada: 2.7.3)

## Como Rodar o Projeto

### 1. Configurar o Wildfly

No diretório `bin` do Wildfly, execute:

```bash
./standalone.sh -c=standalone-full.xml
./add-user.sh -u admin -p senhaadmin -e
```

### 2. Configurar o Banco de Dados

Abra o arquivo hsqldb-2.7.3.jar e rodar o script da pasta `docs` 

### 3. Adicionar o Módulo do HSQLDB ao Wildfly

No diretório bin do Wildfly, abra o jboss-cli.bat e execute o seguinte comando para adicionar o driver:

```bash
module add --name=br.inatel.dm110.org.hsqldb --dependencies=javax.transaction.api --export-dependencies=javax.api --resources=C:\diretorio\do\hsqldb-2.7.3.jar
```

### 4. Configurar o Driver e Datasource

- Acesse o console do Wildfly em http://127.0.0.1:9990:

- Navegue até Configuration -> Subsystems -> Datasources & Drivers.

 Adicionar JDBC Driver:
```bash
Name: HSQLDBDriver
Driver Module Name: br.inatel.dm110.org.hsqldb
Driver Class Name: org.hsqldb.jdbc.JDBCDriver
```
 Adicionar Datasource:
```bash
Custom template
Name: customerPU
JNDI name: java:/customerPU
JDBC Driver: HSQLDBDriver
Connection URL: jdbc:hsqldb:file:C:\diretorio\da\database\dm110.db
UserName: userdobanco
Password: senhadobanco
```
Reinicie o Wildfly após a configuração.

### 5. Recompilar e Fazer Deploy do Projeto (manualmente)

No diretório do projeto, execute:

```bash
mvn clean install
```

Em seguida, faça o deploy do arquivo .ear gerado pelo Maven através do console do Wildfly. Exemplo de caminho para o .ear:
```bash
C:\INATEL\DM110\trabalho-dm110\trabalho-ear\target
```

###  6. Verificar a Aplicação
Acesse a aplicação no navegador para verificar se está rodando: http://127.0.0.1:8080/trabalho-web

### 7. Testar Endpoints
Utilize a collection de endpoints da pasta `docs` para testar a API.
