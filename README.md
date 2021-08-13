## 🔥  Proyecto de prueba de Poker


![npm](https://img.shields.io/badge/Java-1.8-orange) 
![npm](https://img.shields.io/badge/Spring Boot-2.5.3-blue)

- Es necesario importar el proyecto como proyecto de springboot para ejecutarlo, al iniciarlo se ejecutara en el puerto 8081 quedando de la siguiente manera la url:

```
http://localhost:8081/poker/"cantidad de jugadores"
http://localhost:8081/poker/5
```
## Tiene una validacion de 2 hasta 5 jugadores y solo se debe ejecutar la url.

#### El proyecto esta incompleto por falta de tiempo mia y falto que designara al ganador cuando se empata en alguna mano con los mismos valores de cartas.

#### el Response es el siguiente;


Response

```

[
    {
        "mano": [
            "s-8",
            "c-6",
            "h-4",
            "s-J",
            "d-J"
        ],
        "resultado": "One Pair",
        "valorResultado": 9,
        "ganador": true,
        "numeroJugador": 1
    },
    {
        "mano": [
            "d-9",
            "c-8",
            "s-7",
            "h-K",
            "s-Q"
        ],
        "resultado": "K",
        "valorResultado": 10,
        "ganador": false,
        "numeroJugador": 2
    }
]

```
