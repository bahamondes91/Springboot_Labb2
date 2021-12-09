# Springboot_Labb2
Webservice


Endpoints : 
Create Pizza :  http://localhost:8080/pizzas

Get pizza : http://localhost:8080/pizzas/{id}

get all pizza: http://localhost:8080/pizzas

update pizza: http://localhost:8080/pizzas/{id}

delete pizza :  http://localhost:8080/pizzas/{id}
---------------------------------------------

min egna Test metod ligger i PizzaMVCTest.

-------------------------------------------
RABBITMQ:

1. Starta först SpringBootApp
2. Skicka pizzan via insomnia  endpoint:  http://localhost:8080/publish
3. stäng av SpringBootApp
4. Starta RabbitMQListenerAPP
5. Få den beställda pizzan som resultat :D
