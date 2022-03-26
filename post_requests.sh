#!/bin/bash
#Создание пользователей
curl -X POST -H "Content-Type: application/json" -d "{\"username\": \"user_1\"}" http://localhost:9000/users/add

curl -X POST -H "Content-Type: application/json" -d "{\"username\": \"user_2\"}" http://localhost:9000/users/add

curl -X POST -H "Content-Type: application/json" -d "{\"username\": \"user_3\"}" http://localhost:9000/users/add

curl -X POST -H "Content-Type: application/json" -d "{\"username\": \"user_4\"}" http://localhost:9000/users/add

curl -X POST -H "Content-Type: application/json" -d "{\"username\": \"user_5\"}" http://localhost:9000/users/add

#Создание чатов

curl -X POST -H "Content-Type: application/json" -d "{\"name\": \"chat_1\", \"users\": [\"1\", \"2\", \"3\"]}" http://localhost:9000/chats/add 

curl -X POST -H "Content-Type: application/json" -d "{\"name\": \"chat_2\", \"users\": [\"3\", \"4\", \"5\"]}" http://localhost:9000/chats/add 

#Создание сообщений

curl -X POST -H "Content-Type: application/json" -d "{\"chat\": \"1\", \"author\": \"1\", \"text\": \"Hello\"}" http://localhost:9000/messages/add

curl -X POST -H "Content-Type: application/json" -d "{\"chat\": \"1\", \"author\": \"2\", \"text\": \"Google\"}" http://localhost:9000/messages/add

curl -X POST -H "Content-Type: application/json" -d "{\"chat\": \"1\", \"author\": \"3\", \"text\": \"Yandex\"}" http://localhost:9000/messages/add

curl -X POST -H "Content-Type: application/json" -d "{\"chat\": \"2\", \"author\": \"3\", \"text\": \"Amazon\"}" http://localhost:9000/messages/add

curl -X POST -H "Content-Type: application/json" -d "{\"chat\": \"2\", \"author\": \"4\", \"text\": \"Sber\"}" http://localhost:9000/messages/add

curl -X POST -H "Content-Type: application/json" -d "{\"chat\": \"2\", \"author\": \"5\", \"text\": \"Apple\"}" http://localhost:9000/messages/add