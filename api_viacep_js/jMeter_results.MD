# Avaliação de Desempenho da API REST - ViaCEP

Este projeto tem como objetivo avaliar o desempenho da API REST implementada para consultar o ViaCEP, medindo diversos parâmetros de desempenho, incluindo tempo de resposta, taxa de transferência, erro percentual, conexões ativas e pico de conexões.

## Endpoint Testado

`http://localhost:3000/cep/44004000`

## Parâmetros

- **Number of Threads**: 250
- **Ramp-Up Period**: 10 segundos
- **Loop Count**: 5

## Resultados do Teste

### Tempo de Resposta

- **Tempo de Resposta Médio**: 179 ms
- **Tempo de Resposta Mínimo**: 131 ms
- **Tempo de Resposta Máximo**: 928 ms
- **Throughput**: 117,5 requisições/segundo
- **Error %**: 0.00%

## Gráficos de Desempenho

### Taxa de Transferência (Throughput)

### Resultados em Tabela

## Conclusão

A análise de desempenho revela que a API REST para consulta ao ViaCEP opera de forma eficiente sob a carga de teste aplicada, com uma taxa de erro nula (0.00%). Um ponto de atenção observado foi o bloqueio de IP durante a execução dos testes, o que indica a provável existência de um mecanismo de limitação de requisições (_rate limiting_) por parte do serviço externo ViaCEP. Portanto, para futuros testes de carga mais intensivos, é crucial considerar esses limites de requisição para evitar a distorção dos resultados e garantir a integridade da avaliação.
