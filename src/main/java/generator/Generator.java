package generator;

//import com.basic.hellorabbit.dto.UsersDTO; (TestPerson)

import com.github.javafaker.Faker;
import data.TestPerson;

import java.util.Locale;

public class Generator {
    public TestPerson getPerson() {
        // Настройка языка, регион
        Locale locale = new Locale("ru", "RU");
        // Создать объект
        Faker faker = new Faker(locale);


        TestPerson testPerson = new TestPerson(
                faker.name().fullName(),
                faker.internet().emailAddress(),
                faker.address().fullAddress(),
                faker.address().fullAddress()
        );
        System.out.println(testPerson);

        return testPerson;
    }
}
