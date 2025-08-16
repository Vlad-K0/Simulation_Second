package com.Vlad_ko.Simulation.Utils.Validation;

import java.util.Set;

public class InfiniteOrStepToStepMode implements InputValidator<Boolean>{
    private static final Set<String> INFINITE_MODE_OPTIONS = Set.of("б", "бесконечный", "i", "infinite");
    private static final Set<String> STEP_BY_STEP_OPTIONS = Set.of("п", "пошаговый", "s", "step by step");

    @Override
    public boolean isValid(String input) {
        String normalized = input.trim().toLowerCase();
        return INFINITE_MODE_OPTIONS.contains(normalized) || STEP_BY_STEP_OPTIONS.contains(normalized);
    }

    @Override
    public Boolean parse(String input) {
        String normalized = input.trim().toLowerCase();
        return INFINITE_MODE_OPTIONS.contains(normalized);
    }
}
