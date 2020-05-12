package service;

import model.User;

public class UserCreator {

    public static final String TESTDATA_USER_EMAIL = "email";
    public static final String TESTDATA_USER_PASSWORD = "password";
    public static final String FILE_NAME = "user";

    public static User withCredentialsFromProperty(){
        return new User(TestDataReader.getJsonTestData(FILE_NAME, TESTDATA_USER_EMAIL),
                TestDataReader.getJsonTestData(FILE_NAME, TESTDATA_USER_PASSWORD));
    }
}
