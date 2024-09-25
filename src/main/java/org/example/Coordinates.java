package org.example;

public record Coordinates(int x, int y, Sign sign) {
    public static Coordinates parse(String input, Sign sign) {
        String[] split = input.split(",");
        return new Coordinates(
                Integer.parseInt(split[0]),
                Integer.parseInt(split[1]),
                sign);
    }
}
