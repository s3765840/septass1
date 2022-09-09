package com.example.septass1.exception;


    public class ItemNotFoundException extends RuntimeException {

        public ItemNotFoundException(int id) {
            super("Could not find Item " + id);
        }
    }
