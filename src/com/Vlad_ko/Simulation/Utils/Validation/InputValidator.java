package com.Vlad_ko.Simulation.Utils.Validation;

public interface InputValidator<T> {
    boolean isValid(String input);
    T parse(String input);
}
