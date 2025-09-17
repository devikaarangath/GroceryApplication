package Utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	Faker faker = new Faker();
	public String createRandomUserName() {
		return faker.name().username();
	}
	public String createRandomPassword() {
		return faker.internet().password();
		
	}
	public String createRandomFullname() {
		return faker.name().fullName();
	}
    public String createRandonEmailAddress() {
    	return faker.internet().emailAddress();
    }
    public String createRandonText() {
    	return faker.name().username();
    }
}
