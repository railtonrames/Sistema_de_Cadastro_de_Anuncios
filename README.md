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

Para compilar o projeto a partir do netbeans:
- Passo 1: realize o download do projeto e extraia ele na sua pasta de projetos ou clone este repositório com o comando abaixo: 
```bash
git clone https://github.com/railtonrames/Sistema_de_Cadastro_de_Anuncios.git
```
Ou

<img src="https://github.com/railtonrames/Sistema_de_Cadastro_de_Anuncios/blob/master/assets/Download.png" width="200"/>) ![Extract](https://github.com/railtonrames/Sistema_de_Cadastro_de_Anuncios/blob/master/assets/Extract.png" alt="Download" width="200"/>

![Download](<img src = "https://github.com/railtonrames/Sistema_de_Cadastro_de_Anuncios/blob/master/assets/Download.png" width="200"/>) ![Extract](https://github.com/railtonrames/Sistema_de_Cadastro_de_Anuncios/blob/master/assets/Extract.png)

- Passo 2: Abra o Netbeans, no menu vá em file>Open Project... ou (Ctrl+Shift+O), vá até a pasta que contém o projeto, selecione ele e clique no botão "Open Project".
![OpenProject](https://github.com/railtonrames/Sistema_de_Cadastro_de_Anuncios/blob/master/assets/OpenProject.PNG)

- Passo 3: Aperte a tecla F6 para rodar o projeto.
![RunProject](https://github.com/railtonrames/Sistema_de_Cadastro_de_Anuncios/blob/master/assets/RunProject.PNG)

Para executar o projeto a partir da linha de comando, vá para a pasta dist e digite o seguinte:
```bash
java -jar "CadastroDeAnuncios.jar"
```

# Autor

Railton Rames Sousa

https://www.linkedin.com/in/railton-rames/
