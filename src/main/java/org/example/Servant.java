package org.example;

public class Servant extends Person {
    public Servant() {
        flowers = new Flowers(this);
        set_the_name();
        set_the_method_of_transportation();
        set_the_protective_pet();
    }

    private Flowers flowers = null;
    public Flowers getFlowers() {
        return flowers;
    }

    public void setFlowers(Flowers flowers) {
        this.flowers = flowers;
    }
    @Override
    public void return_person_param()
    {
        System.out.println("Наш покорный слуга, приветствуем!");
        System.out.println("Ваш способ передвижения - " + getMethod_of_transportation());
        System.out.println("Ваш охранник - " + getProtective_pet());
        System.out.println("Ваше имя - " + getName());
    }
}
