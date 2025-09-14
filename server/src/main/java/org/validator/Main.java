package org.validator;

public class Main {
    public static void main(String[] args) {
        try {
            ExampleDTO exampleDTO = ValidatedRecordFactory.create(
                    ExampleDTO.class,
                    "0"
            );
            System.out.println(exampleDTO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}