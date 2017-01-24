package store.enums;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static store.Messages.DEFAULT_DISPLAY_FIELD_PATTERN;

public enum ProductField {
    Name, Id, Price, Description, Type;

    private static Set<ProductField> creationFields =
            new LinkedHashSet<>(Arrays.asList(Name, Price, Description, Type));

    public static void displayCreationField(){
        final int[] startIndex = {1};
        creationFields.forEach(field ->
                System.out.println(String.format(DEFAULT_DISPLAY_FIELD_PATTERN, startIndex[0]++, field.name())));
    }

    public static void displayFields(String indexValuePattern){
        Arrays.stream(values()).
                forEach(field -> System.out.println(String.format(indexValuePattern, field.ordinal()+1, field.name())));
    }
}
