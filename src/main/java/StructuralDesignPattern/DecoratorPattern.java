// Decorator pattern is a structural pattern.
// It allows us to add functionalities to an object dynamically at runtime.
//
// Suppose we have N optional features. If we create a separate class
// for every possible combination of features, there can be 2^N
// possible combinations, which can become very large.
//
// Instead, we use Decorator pattern to dynamically add the features
// that we want by wrapping the existing object.
//
// Example:
// Basic Pizza
//     ↓
// Cheese Decorator
//     ↓
// Olive Decorator
//
// Each decorator adds its own functionality without modifying
// the original BasicPizza class.


package StructuralDesignPattern;

interface Pizza {
    void Desc();
}


class BasicPizza implements Pizza {

    @Override
    public void Desc() {
        System.out.println("It is a basic Pizza");
    }
}


abstract class PizzaDecorator implements Pizza {

    protected Pizza pizza;

    PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public void Desc() {
        pizza.Desc();
    }
}


class CheeseDecorator extends PizzaDecorator {

    CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public void Desc() {

        // Call the previous object's behavior
        super.Desc();

        // Add new behavior
        System.out.println("With extra cheese");
    }
}


class OliveDecorator extends PizzaDecorator {

    OliveDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public void Desc() {

        // Call the previous object's behavior
        super.Desc();

        // Add new behavior
        System.out.println("With extra olives");
    }
}


public class DecoratorPattern {

    public static void main(String[] args) {

        Pizza pizza = new BasicPizza();

        pizza.Desc();

        // Add cheese dynamically
        pizza = new CheeseDecorator(pizza);

        pizza.Desc();

        // Add olives dynamically
        pizza = new OliveDecorator(pizza);

        pizza.Desc();
    }
}