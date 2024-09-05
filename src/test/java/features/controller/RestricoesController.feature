#language: pt
#encoding: utf-8
#autor: Jehymeson Gil Alves Oliveira

@Restricoes
Funcionalidade: Restricoes

Cenario: Consultar uma restricao pelo CPF - Com Restricao
	Quando eu consulto pelo cpf "97093236014" em /restricoes/
	Entao espero receber o codigo 200 da restricao
	
Cenario: Consultar uma restricao pelo CPF - Sem Restricao
	Quando eu consulto pelo cpf "99999999999" em /restricoes/
	Entao espero receber o codigo 204 da restricao