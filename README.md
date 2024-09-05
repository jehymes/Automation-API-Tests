# **SICREDI Automação API**

Projeto de automação de API desenvolvido para treinamento de habilidades e técnicas.


## Estrutura do Projeto
```
src
|-main
| |-resources
| | |-cucumber.properties
|-test
| |-java
| | |-features
| | | |-controller
| | | | |-RestricoesController.feature
| | | | |-SimulacaoController.feature
| | |-runners
| | | |-controller
| | | | |-RestricoesRunner.feature
| | | | |-SimulacaoRunner.feature
| | |-steps
| | | |-config
| | | | |-RestAssuredConfig.java
| | | |-controller
| | | | |-RestricoesStepsDefinitions.java
| | | | |-SimulacaoStepsDefinitions.java
| | | |-generic
| | | | |-GenericStepsDefinitions.java
| | |-utils
| | | | |-Utils.java
```


## Começando

Essas instruções fornecerão uma cópia do projeto em funcionamento em sua máquina local para fins de desenvolvimento e teste. Consulte a implantação de notas sobre como implantar o projeto em um sistema ao vivo.


### Pré-requisitos

O que você precisa para instalar o software e como instalá-los

```
Git
Java 8+ JDK
Maven
```
***Observação: É necessário que o projeto Automation API Tests esteja rodando em seu ambiente.*** 


### Instalando

Crie uma copia do projeto em seu ambiente de desenvolvimento utilizando o Git com um dos comandos abaixo:
``` 
**caminhos aqui**
```

Acesse a pasta do projeto e execute os comandos a seguir:
``` 
mvn clean install -U
```

## Executando os testes

1. Abra o projeto em sua IDE de preferência.
2. Navegue no diretório de pastas até 'src/test/java/runners'
3. Execute o arquivo 'AutomationApiRunner.java'.

Ou execute o comando abaixo em um terminal ou linha de comando:
```
mvn clean install -U -Dtest=runners.AutomationApiRunner
```

## Desenvolvimento

Para criação de novos testes é necessário: 

1. A criação de uma nova feature no pacote de teste, fazendo referência ao pacote e classe a ser testada e inserindo tag para mapeamento na runner.
- Exemplo:
```
#language: pt
#encoding: utf-8
#autor: Seu Nome Aqui

@Emprestimos #<- Criação da Tag para mapeamento na runner
Funcionalidade: Emprestrimos

Cenario: Qual cenário sera testando em Emprestimo
 Quando eu fizer algo
 E acontecer isso
 Entao espero receber alguma coisa
```
<br/>

2. A criação de uma nova step no pacote de teste, fazendo referência ao pacote e classe a ser testada.
    - Aqui ficará toda a lógica para a execução da sua feature
<br/>

3. A criação de uma nova runner no pacote de teste, fazendo referência ao pacote e classe a ser testada.
```
Exemplos: Criação de um novo caso te teste para verificar uma classe EmprestimosController.java contida na pasta controller.
Feature ----------> src.test.java.feature.controller.EmprestimosController.feature
Step Definitions -> src.test.java.steps.controller.EmprestimosStepDefinitions.java
Runner -----------> src.test.java.runners.controller.EmprestimosRunner.java
```
<br/>

4. Inclusão da nova tag criada na feature, dentro das 'tags' em @CucumberOptions da classe AutomationApiRunner.java.
```
...
@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty"}, 
		features = "src/test/java/features/controller", 
		monochrome = true, 
		glue = {"steps"}, 
		tags = "@Restricoes or @Simulacoes or @Emprestimos" // <- Inclusão da nova tag
)
public class AutomationApiRunner { ... }
```
<br/>

## Built With

* [Java](#https://www.java.com/pt-BR/) - Usado na criação das steps definitions.
* [Cucumber](#https://cucumber.io/) - Usada para implementação das features.
* [REST-Assured](#https://rest-assured.io/) - Usado para testar e validar serviços REST em Java
* [JUnit](#https://junit.org/junit4/) - Usado na construção de assertivas e runners para execução dos testes.

## Histórico da Revisão
- Dentro do projeto existe um arquivo com o nome `Histórico da Revisão.txt`, este descreve os cenários testados nesta versão da API bem como seus defeitos e apontamentos para correção dos mesmos.

## Autor

* [**Jehymeson Gil Alves Oliveira**](https://github.com/jehymes)
