package store.enums;
import java.util.LinkedHashSet;
import java.util.Set;

import static store.Messages.DEFAULT_DISPLAY_FIELD_PATTERN;

public enum ProductField {
    Name, Id, Price, Description, Type;

    private static Set<ProductField> creationFields = new LinkedHashSet<>();

    //TODO: JAVA8 streaming
    static {
        creationFields.add(Name);
        creationFields.add(Price);
        creationFields.add(Description);
        creationFields.add(Type);
    }

    //TODO: JAVA8 streaming
    public static void displayCreationField(){
        int startIndex = 1;
        for (ProductField field: creationFields){
            System.out.println(String.format(DEFAULT_DISPLAY_FIELD_PATTERN, startIndex++, field.name()));
        }
    }

    //TODO: JAVA8 streaming
    public static void displayFields(String pattern){
        for (ProductField field: values()){
            System.out.println(String.format(pattern, field.ordinal() + 1, field.name()));
        }
    }
}
