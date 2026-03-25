# Desafio Consulta Vendas

Projeto Spring Boot com consultas JPQL para relatorio de vendas e sumario por vendedor.

## Requisitos

- Java 17+
- Maven Wrapper (ja incluso no projeto)

## Como executar

```powershell
.\mvnw.cmd spring-boot:run
```

API base: `http://localhost:8080`

## Endpoints

### 1) Relatorio de vendas

`GET /sales/report`

Query params opcionais:

- `minDate` (yyyy-MM-dd)
- `maxDate` (yyyy-MM-dd)
- `name` (trecho do nome do vendedor)
- parametros de pagina (`page`, `size`, `sort`)

Exemplo:

`GET /sales/report?minDate=2022-05-01&maxDate=2022-05-31&name=odinson`

### 2) Sumario por vendedor

`GET /sales/summary`

Query params opcionais:

- `minDate` (yyyy-MM-dd)
- `maxDate` (yyyy-MM-dd)

Exemplo:

`GET /sales/summary?minDate=2022-01-01&maxDate=2022-06-30`

## Regras implementadas

- Se `maxDate` vier vazio, usa a data atual do sistema.
- Se `minDate` vier vazio, usa `maxDate.minusYears(1)`.
- Se `name` vier vazio, considera string vazia.

## Testes

```powershell
.\mvnw.cmd test
```

Os testes validam os dois cenarios principais do desafio via camada de servico.

