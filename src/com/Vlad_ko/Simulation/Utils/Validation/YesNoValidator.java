package com.Vlad_ko.Simulation.Utils.Validation;

import java.util.Set;

public class YesNoValidator implements InputValidator<Boolean>{
    private static final Set<String> YES_OPTIONS = Set.of("да", "д", "yes", "y");
    private static final Set<String> NO_OPTIONS = Set.of("нет", "н", "no", "n");

    @Override
    public boolean isValid(String input) {
        String normalized = input.trim().toLowerCase();
        return YES_OPTIONS.contains(normalized) || NO_OPTIONS.contains(normalized);
    }

    @Override
    public Boolean parse(String input) {
        String normalized = input.trim().toLowerCase();
        return YES_OPTIONS.contains(normalized);
    }

}
