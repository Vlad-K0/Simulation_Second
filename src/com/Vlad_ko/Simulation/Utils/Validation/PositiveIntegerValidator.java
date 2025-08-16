package com.Vlad_ko.Simulation.Utils.Validation;

public class PositiveIntegerValidator implements InputValidator<Integer>{
    @Override
    public boolean isValid(String input) {
        try {
            int value = Integer.parseInt(input);
            return value > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public Integer parse(String input) {
        return Integer.parseInt(input);
    }
}
