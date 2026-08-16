//Decorator pattern is a structural pattern which is similar to kind of builder pattern where we decide what functionalities
//        do we want at runtime. let say we have N features so there can be 2^n possibilities of choosing these features
//        it can grow exponentially very large so we use decorator pattern to choose which feature we want dynamically.


package StructuralDesignPattern;

import java.sql.SQLOutput;

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
    Pizza pizza;

    PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public void Desc() {

    }
}

class CheezeDecorator extends PizzaDecorator {

    CheezeDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public void Desc() {
        pizza.Desc();
        System.out.println("with extra cheeze");
    }
}

class OliveDecorator extends PizzaDecorator{
     OliveDecorator(Pizza pizza){
         super(pizza);
     }

     @Override
    public void Desc(){
         pizza.Desc();
         System.out.println("With Extra Olives");
     }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        Pizza pizza = new BasicPizza();
        pizza.Desc();

        pizza = new CheezeDecorator(pizza);
        pizza.Desc();

        pizza = new OliveDecorator(pizza);
        pizza.Desc();
    }
}
