package com.federico.Ecommerce.enums;
import com.fasterxml.jackson.annotation.JsonCreator;
    public enum Rol {
        ADMIN,
        USUARIO;

        @JsonCreator
        public static com.federico.Ecommerce.enums.Rol parse(String value){
            return com.federico.Ecommerce.enums.Rol.valueOf(value.toUpperCase());
        }

        }