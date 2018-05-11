# NerdTalk - Spring Boot  

---
Spring boot é um projeto da pivotal com o objetivo de aumentar a produtividade do dev, abstraindo a complexidade de configurações necessárias durante o desenvolvimento de um projeto, permitindo que o desenvolvedor possa focar em regras de negocio

## Criando o projeto:
Pensado me simplificar o dia a dia do Dev a pivotal desenvolveu algumas formas para se criar um projeto spring boot
 
 * Spring Initializr 
 * Spring Boot CLI

### Spring Initializr

Para criar o projeto através do Spring Initializr basta é necessário
 * Entrar no site 
https://start.spring.io/ 
* criar o projeto com as dependemcias necessárias (web,lombok e mongodb) e em seguida 
* gerar o projeto

### Spring Boot CLI

Para criar o projeto springboot através da CLI  
* baixar a CLI 
https://repo.spring.io/snapshot/org/springframework/boot/spring-boot-cli/2.1.0.BUILD-SNAPSHOT/spring-boot-cli-2.1.0.BUILD-SNAPSHOT-bin.zip
* entrar na pasta e executar o seguinte comando
```sh
./spring init --dependencies=web,lombok,data-mongodb nerdtalk-springboot
```

em seguida podemos abrir o projeto e já subir a aplicação


## Starters do SpringBoot
 O Spring Boot nos Oferece uma coleção de dependencias que podem ser incluidas para a sua aplicação, conhecidos como starters , como por exemplo:

 * __spring-boot-starter-amqp__
 * __spring-boot-starter-web__
 * __spring-boot-starter-thymeleaf__

Através deles se torna mais facil o gerenciamento de dependencias, pelos controles das versões e por ter um POM mais limpo

## Auto-Configuration
 Uma das formas que o springboot utiliza para facilitar o nosso dia a dia seria através de configurações automaticas que ele realiza utilizando a anotação __@SpringBootApplication__ ou __@EnableAutoConfiguration__ e as dependencias do seu projeto


 
## Developer Tools
O Spring Boot tambem nos oferece um conjunto de ferramentas para nós ajudar no desevolvimento através do __SpringDevTools__
  
 ```sh
<dependencies>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-devtools</artifactId>
		<optional>true</optional>
	</dependency>
</dependencies> 
```
o __SpringDevTools__ ajuda para que toda vez que houver uma alteração no classpath do projeto, então ele da um restart automatico, permitindo que esteja sempre atualizado

O Automatic Restart pode depender muito da IDE, no eclipse um simples save de arquivo já pode causar um restar, já no intelliJ apenas após um Build

## Actuator

O Actuator é um dos startes do springBoot ele nós da uma série de endpoints para nós dar mais visibilidade uma vez que nossa aplicação está no ar

 ```sh
<dependencies>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-actuator</artifactId>
		<optional>true</optional>
	</dependency>
</dependencies> 
```
porém para expormos esses endpoints será necessario configurar quais queremos habilitar nas propriedades com o comando
```sh
management.endpoints.jmx.exposure.include
```
como queremos todos para testar vamos passar o valor __" * "__

Agora podemos bater no endpoint __/actuator/health__, se tudo estiver certo deverá aparecr o status da sua aplicação
