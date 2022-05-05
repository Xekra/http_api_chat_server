package com.chulyukin.yourcodereview.task2.exception;

/**
 * Класс исключений сервис слоя
 */
public class ServiceException extends RuntimeException{
    public ServiceException(String message) {
        super(message);
    }
}
