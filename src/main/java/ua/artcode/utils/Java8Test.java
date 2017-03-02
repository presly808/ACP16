package ua.artcode.utils;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by serhii on 28.01.17.
 */
public class Java8Test {

    public static final int MIN_USER_AGE = 18;
    public static final int MAX_USER_AGE = 80;

    public static void main(String[] args) {

        List<User> users = generateUsers();


        List<Pet> pets = new ArrayList<>();
        Map<PetType, Long> mapPets = users.stream().filter((user) -> user.age >= 18 && user.age < 30)
                .flatMap(user -> user.pets.stream()).collect(
                        Collectors.groupingBy(new Function<Pet, PetType>() {
                            @Override
                            public PetType apply(Pet t) {
                                return t.type;
                            }
                        }, Collectors.counting()));


        mapPets.forEach((key, value) -> {
            System.out.printf("key %s, value %s\n", key, value);
        });



    }

    private static List<User> generateUsers() {
        return Stream.generate(() -> {

            String name = UUID.randomUUID().toString();
            int userAge = MIN_USER_AGE + (int) (Math.random() * (MAX_USER_AGE - MIN_USER_AGE));

            List<Pet> pets = generatePets(10);

            return new User(name, userAge, pets);

        }).limit(100).collect(Collectors.toList());
    }

    private static List<Pet> generatePets(int size) {
        return Stream.generate(() -> generatePet()).limit(size)
                .collect(Collectors.toList());
    }

    private static Pet generatePet() {
        String name = UUID.randomUUID().toString();
        int randomPetTypeIndex = (int) (Math.random() * PetType.values().length);
        PetType randomType = PetType.values()[randomPetTypeIndex];

        return new PetBuilder()
                .setHealth(true)
                .setType(randomType)
                .setName(name + randomType)
                .build();
    }


    static class User {

        final String name;
        final int age;
        final List<Pet> pets;

        public User(String name, int age, List<Pet> pets) {
            this.name = name;
            this.age = age;
            this.pets = pets;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", pets=" + pets +
                    '}';
        }
    }

    static class PetBuilder {
        PetType type;
        String name;
        boolean health;

        public PetBuilder setType(PetType type) {
            this.type = type;
            return this;
        }

        public PetBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PetBuilder setHealth(boolean health) {
            this.health = health;
            return this;
        }

        public Pet build() {
            return new Pet(type, name, health);
        }
    }

    private static class Pet {
        final PetType type;
        final String name;
        final boolean health;

        public Pet(PetType type, String name, boolean healt) {
            this.type = type;
            this.name = name;
            this.health = healt;
        }

        public PetType getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        public boolean isHealth() {
            return health;
        }

        @Override
        public String toString() {
            return "Pet{" +
                    "type=" + type +
                    ", name='" + name + '\'' +
                    ", health=" + health +
                    '}';
        }
    }

    private enum PetType {
        DOG, CAT, FISH;

    }
}




