package model;

import java.util.Objects;

public class Card {

    private String numberCard;
    private String month;
    private String year;
    private String name;

    public Card(String numberCard, String month, String year, String name) {
        this.numberCard = numberCard;
        this.month = month;
        this.year = year;
        this.name = name;
    }

    public Card() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(numberCard, card.numberCard) &&
                Objects.equals(month, card.month) &&
                Objects.equals(year, card.year) &&
                Objects.equals(name, card.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberCard, month, year, name);
    }

    public String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
