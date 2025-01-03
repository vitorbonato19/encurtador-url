# Desafio BackEndBR - Encurtador de URL's

Projeto desenvolvido como minha interpretação de um desafio do [Backend-br](https://github.com/backend-br/desafios/blob/master/url-shortener/PROBLEM.md) para testar minhas capacidades na linguagem e melhoria da minha lógica.

## Exemplo

O serviço recebe uma chamada para encurtar uma URL.

**[POST]** `{{host}}/shorten-url`

E retorna um JSON com a URL encurtada:

```
HTTP/1.1 200 OK
```

```json
{
    "defaultUrl": "https://www.google.com/",
    "shortUrl": "MZaQqJCDY",
    "createdAt": "2025-01-02T22:59:57.491162",
    "expireAt": "2025-01-02T23:02:57.491162"
}
```

Ao receber a chamada na URL encurtada, ele redireciona para a URL original com 
```
HTTP/1.1 302 FOUND
```
### Requisição GET

**[GET]** `{{host}}/MZaQqJCDY`

Fazendo o navegador interpretar o HttpStatus e redirecionar para o url original informado no POST.

Aberto a críticas e melhorias, sempre.
