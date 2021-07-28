package Pages;

import Pages.Person;

public class UserGenerator {

    public Person userGenerator() {
        String randomNumber = String.valueOf(System.currentTimeMillis());
        Person person = new Person();
        person.setName(randomNumber);
        person.setEmail(randomNumber + "@mail.ru");
        person.setPassword(randomNumber);

        return person;
    }
}
