# Sistema de Cadastro de Anúncios

# Sobre o projeto

Sistema de Cadastro de Anúncios é um programa que permite o cadastro de anúncios com relatórios, feito em Java e com conexão à banco de dados sql, contruído durante o **Desafio de Programação Academia Capgemini**, é a segunda parte do desafio organizado pela [ProWay](https://www.proway.com.br/academiatecnicacapgeminidesafio "Site do Desafio").

O programa consiste em um cadastro de anúncios, onde baseado nos valores inseridos é gerado um relatório indicando valor total investido, quatidade máxima de visualizações, cliques e compartilhamentos. Os dados inseridos são armazenados em um banco de dados sql, conta com uma interface gráfica para realizar as operações do CRUD e os relatórios podem ser filtrados por cliente e/ou intervalo de tempo.

## Layout
### Menu
![View 1](https://github.com/railtonrames/Sistema_de_Cadastro_de_Anuncios/blob/master/assets/View_Menu.PNG)
### Tela de Cadastro
![View 2](https://github.com/railtonrames/Sistema_de_Cadastro_de_Anuncios/blob/master/assets/View_Cadastrar_Ex.PNG)
### Tela de Relatórios
![View 3](https://github.com/railtonrames/Sistema_de_Cadastro_de_Anuncios/blob/master/assets/View_Relatorios_Ex.PNG)
### Tela de Editar e Excluir
![View 4](https://github.com/railtonrames/Sistema_de_Cadastro_de_Anuncios/blob/master/assets/View_Editar-Excluir.PNG)

## Modelo Lógico
![Modelo Lógico](https://github.com/railtonrames/Sistema_de_Cadastro_de_Anuncios/blob/master/assets/L%C3%B3gico_Cadastro_de_Anuncios.png)

# Tecnologias utilizadas
## Ambientes de desenvolvimento
- Apache Netbeans IDE 12.0
- Xampp
## Bibliotecas
- mysql-connector-java-5.1.47.jar
- JDK 14.0.2
## Implantação
- Front/Back end: Java
- Banco de dados: MariaDB

# Como compilar e executar o projeto
Pré-requisitos: JDK 14, Netbeans 12 e Xampp.

## Para compilar o projeto a partir do netbeans:
- Passo 1: realize o download do projeto e extraia ele na sua pasta de projetos ou clone este repositório com o comando abaixo: 

```bash
git clone https://github.com/railtonrames/Sistema_de_Cadastro_de_Anuncios.git
```
Ou

![Download_Extract](https://github.com/railtonrames/Sistema_de_Cadastro_de_Anuncios/blob/master/assets/Download_Extract.png)

- Passo 2: Crie um banco de dados local na sua máquina, com o nome "db_cadastro_anuncios", caso esteja utilizando o xampp, abra seu navegador e digite "http://localhost/phpmyadmin/", em seguida clique em novo, preencha o campo com "db_cadastro_anuncios" e clique em criar:

![Download_Extract](https://github.com/railtonrames/Sistema_de_Cadastro_de_Anuncios/blob/master/assets/CriaBD.png)

```sql
create database db_cadastro_anuncios;
```

- Passo 3: Selecione o banco de dados criado e importe o dump (estrutura e registros) localizado na raiz do projeto, chamado de [db_cadastro_anuncios.sql](https://github.com/railtonrames/Sistema_de_Cadastro_de_Anuncios/blob/master/db_cadastro_anuncios.sql):

![ImportaDump](https://github.com/railtonrames/Sistema_de_Cadastro_de_Anuncios/blob/master/assets/ImportaDump.png)

- Passo 4: Abra o Netbeans, no menu vá em file>Open Project... ou (Ctrl+Shift+O), vá até a pasta que contém o projeto, selecione ele e clique no botão "Open Project".
![OpenProject](https://github.com/railtonrames/Sistema_de_Cadastro_de_Anuncios/blob/master/assets/OpenProject.PNG)

- Passo 5: Aperte a tecla F6 para rodar o projeto.
![RunProject](https://github.com/railtonrames/Sistema_de_Cadastro_de_Anuncios/blob/master/assets/RunProject.PNG)

## Para executar o projeto a partir da linha de comando, vá para a pasta dist e digite o seguinte:
```bash
java -jar "CadastroDeAnuncios.jar"
```

# Autor

Railton Rames Sousa

https://www.linkedin.com/in/railton-rames/
