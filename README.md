# Controle de Finanças Pessoais em Java

## Visão Geral

Este projeto é um aplicativo de controle de finanças pessoais desenvolvido em Java. Ele oferece uma solução eficiente para gerenciar receitas, despesas, economias e orçamentos. O aplicativo é projetado para ser simples, intuitivo e poderoso, fornecendo aos usuários uma visão clara de sua saúde financeira e ajudando-os a tomar decisões mais informadas sobre suas finanças.

## Funcionalidades

- **Gerenciamento de Despesas e Receitas**: Registre e acompanhe suas despesas e receitas diárias.
- **Categorização**: Organize suas transações em categorias personalizáveis.
- **Visualização de Dados**: Veja relatórios.
- **Orçamentação**: Estabeleça e acompanhe seu orçamentos mensal.
- **Lembretes de Pagamento**: Configure lembretes para contas e pagamentos recorrentes.
- **Segurança dos Dados**: Seus dados financeiros são armazenados com segurança.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação para a lógica do aplicativo.
- **Quarkus**: Framework usado.

# Documentação

## Resources

- **v1**: Qualquer endpoint implementado deve conter o v1 na path. `@Path("v1/register")`
-  **Create**: Todo método que criar algum registro a primeria vez, deve devolver uma URI com a location para acessar o novo registro. Além do código 201 CREATED.
-   **Update**: Os métodos que atualizam um registro, devem devolver status 200 OK, com a Entity atualizada.

## Services

- **Padrão**: Todos os service terão uma interface, e todo metodo deve ser uma implementação do contrato da interface

## Repository

- **findById**: Sempre optar pelo metodo que devolve um Optional
