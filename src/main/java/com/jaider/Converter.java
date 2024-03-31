package com.jaider;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Converter {
    public static <T, U> U convertTo(T entityOrigin, Class<U> entityFinalClass)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        U entidadDestino = entityFinalClass.getDeclaredConstructor().newInstance(); // Obtener instancia de la entidad destino
        Field[] fieldsEntityOrigin = entityOrigin.getClass().getDeclaredFields(); // Obtener todos los campos de la entidad origen
        for (Field fieldOrigin : fieldsEntityOrigin) {
            fieldOrigin.setAccessible(true); // Hacer accesible el campo privado
            Object valor = fieldOrigin.get(entityOrigin); // Obtener el valor del campo en la instancia de la entidad origen
            if (valor != null) {
                try {
                    Field campoDestino = entityFinalClass.getDeclaredField(fieldOrigin.getName());
                    campoDestino.setAccessible(true); // Hacer accesible el campo privado
                    campoDestino.set(entidadDestino, valor);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                }
            }
        }
        return entidadDestino;
    }
}
