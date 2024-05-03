package org.example;

public class Pricess extends Person{

    private Person person;
    public Pricess() {
        dresses = new Dresses(this);
        set_the_name();
        set_the_method_of_transportation();
        set_the_protective_pet();
    }
    private Dresses dresses = null;
    public Dresses getDresses() {
        return dresses;
    }
    public void setDresses(Dresses dresses) {
        this.dresses = dresses;
    }

    @Override
    public void return_person_param()
    {
        System.out.println("Ой наша принцесса!");
        System.out.println("Ваш способ передвижения - " + getMethod_of_transportation());
        System.out.println("Ваш охранник - " + getProtective_pet());
        System.out.println("Ваше имя - " + getName());
    }
}
