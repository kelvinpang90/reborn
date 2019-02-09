package com.reborn.test.design_pattern.builder;

public class Test {
    public static void main(String[] args){
        MealBuilder mealBuilder = new MealBuilder();
        Meal meal = mealBuilder.prepare("chickenBurger","Coke");
        meal.showMeal();
        System.out.println(meal.getTotalPrice());
    }
}
