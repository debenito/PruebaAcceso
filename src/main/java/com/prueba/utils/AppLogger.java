package com.prueba.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.prueba.exceptions.PersonalizadaException;

/**
 * 
 * @author Jose Antonio de Benito Suárez
 * Clase de utilidades para la gestion de logs.
 *
 */
public class AppLogger {
    private static Gson gson = new Gson();

    public static void info(String sessionKey, String message, Object json, Class<?> target) {
        final Logger logger = LoggerFactory.getLogger(target);
        logger.info("Sessionkey: "+sessionKey+" -> "+message + " " + gson.toJson(json));

    }

    public static void info(String sessionKey, String message, Class<?> target) {
        final Logger logger = LoggerFactory.getLogger(target);
        logger.info("Sessionkey: "+sessionKey+" -> "+message);

    }

    public static void error(String sessionKey, PersonalizadaException e, Class target) {
        final Logger logger = LoggerFactory.getLogger(target);
        logger.error("Sessionkey: "+sessionKey+" -> "+ e);

    }



    public static void debug(String sessionKey, String message, Class<?> target) {
        final Logger logger = LoggerFactory.getLogger(target);
        logger.debug("Sessionkey: "+sessionKey+" -> "+message);

    }
}
