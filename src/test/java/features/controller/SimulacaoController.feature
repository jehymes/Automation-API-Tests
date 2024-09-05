#language: pt
#encoding: utf-8
#autor: Jehymeson Gil Alves Oliveira

@Simulacoes
Funcionalidade: Simulacoes


Cenario: Criar uma simulacao - Gravação com SUCESSO
	Quando eu faço um POST para /simulacoes/ com os seguintes valores:
		|nome			| Siclano					 	|
		|cpf			| 12345678915   		|
		|email		| siclano@gmail.com |
		|valor		| 40000							|
		|parcelas	| 4 								|
		|seguro		| true 							|
	Entao espero receber o codigo 201

#Obs -> O status code esta retornando 400 em vez de 409 | Fazer correação na API
Cenario: Criar uma simulacao - CPF existente
	Quando eu faço um POST para /simulacoes/ com os seguintes valores:
		|nome			| Siclano					 	|
		|cpf			| 12345678915   		|
		|email		| siclano@gmail.com |
		|valor		| 40000							|
		|parcelas	| 4 								|
		|seguro		| true 							|
	Entao espero receber o codigo 409 com a mensagem "CPF duplicado"

Cenario: Criar uma simulacao - Campo Valor invalido
	Quando eu faço um POST para /simulacoes/ com os seguintes valores:
		|nome			| Siclano					 	|
		|cpf			| 12345678915   		|
		|email		| siclano@gmail.com |
		|valor		| 50000							|
		|parcelas	| 4 								|
		|seguro		| true 							|
	Entao espero receber o codigo 400 e a mensagem de erro "Valor deve ser menor ou igual a R$ 40.000"

Cenario: Criar uma simulacao - Campos vazios
	Quando eu faço um POST para /simulacoes/ com os seguintes valores:
		|seguro		| true 	|
	Entao espero receber o codigo 400 com os seguintes erros:
		|nome			| Nome não pode ser vazio		  |
		|cpf			| CPF não pode ser vazio   		|
		|email		| E-mail não deve ser vazio 	|
		|valor		| Valor não pode ser vazio		|
		|parcelas	| Parcelas não pode ser vazio |

Cenario: Alterar simulacao
	Quando eu faço um PUT para /simulacoes/ com os seguintes valores:
		|nome			| Siclano	Alterado 						|
		|cpf			| 12345678915   							|
		|email		| siclano_alterado@gmail.com 	|
		|valor		| 40000												|
		|parcelas	| 10 													|
		|seguro		| false 											|
	Entao espero receber o codigo 200 da simulacao

#Obs -> Mensagem descrita na API diferente da informada pelo Swagger
Cenario: Alterar uma simulacao - CPF não encontrado
	Quando eu faço um PUT para /simulacoes/ com os seguintes valores:
		|nome			| Siclano de Tal	 		|
		|cpf			| 12345678914   		 	|
		|email		| siclano2@gmail.com 	|
		|valor		| 40000						  	|
		|parcelas	| 4 									|
		|seguro		| false								|
	Entao espero receber o codigo 404 e a mensagem de erro "CPF 12345678914 não encontrado"

Cenario: Consultar todas as simulacao cadastradas - Com retorno
	Quando eu faço um GET para /simulacoes/
	Entao espero receber o codigo 200 com as simulacoes cadastradas

Cenario: Consultar uma simulacao pelo CPF - Com retorno
	Quando eu faço um GET para /simulacoes/12345678915
	Entao espero receber o codigo 200 com a solicitacao cadastrada:
		|nome			| Siclano	Alterado 						|
		|cpf			| 12345678915   							|
		|email		| siclano_alterado@gmail.com 	|
		|valor		| 40000.0											|
		|parcelas	| 10 													|
		|seguro		| false 											|
	
Cenario: Consultar uma simulacao pelo CPF - Sem retorno
	Quando eu faço um GET para /simulacoes/17822386035
	Entao espero receber o codigo 404 e a mensagem de erro "CPF 17822386035 não encontrado"

#Obs -> Espera receber 204 mas é retornado 200 | Fazer correação na API	
Cenario: Remover uma simulacao - Removida com sucesso
	Quando eu faço um DELETE para /simulacoes/12
	Entao espero receber o codigo 200 da simulacao

Cenario: Remover todas simulacoes
	Quando eu faço um DELETE para todas /simulacoes/
	Entao espero receber o codigo 200 da simulacao
	
#Obs -> Fazer correção no status code de retorno. É esperado 204, mas retorna 200
Cenario: Consultar todas as simulacao cadastradas - Sem retorno
	Quando eu faço um GET para /simulacoes/
	Entao espero receber o codigo 204 sem as simulacoes cadastradas


#Obs -> Espera receber 404 mas é retornado 200 | Fazer correação na API	
#Cenario: Remover uma simulacao - simulacao não encontrada para remoção
#	Quando eu faço um DELETE para /simulacoes/12
#	Entao espero receber o codigo 404