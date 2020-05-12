package service;

import model.Card;

public class CardCreator {

    public static final String TESTDATA_USER_NUMBER_CARD = "card";
    public static final String TESTDATA_USER_NAME = "name";
    public static final String TESTDATA_USER_MONTH = "month";
    public static final String TESTDATA_USER_YEAR = "year";
    public static final String FILE_NAME = "card";

    public static Card withCredentialsFromProperty(){
        return new Card(TestDataReader.getJsonTestData(FILE_NAME, TESTDATA_USER_NUMBER_CARD),
                TestDataReader.getJsonTestData(FILE_NAME, TESTDATA_USER_MONTH),
                TestDataReader.getJsonTestData(FILE_NAME, TESTDATA_USER_YEAR),
                TestDataReader.getJsonTestData(FILE_NAME, TESTDATA_USER_NAME));
    }
}
