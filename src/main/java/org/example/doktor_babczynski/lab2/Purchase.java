package org.example.doktor_babczynski.lab2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Purchase implements  Comparable{
    private long id;
    private LocalDate time;
    private BigDecimal amount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                "date = " + time +
                "money = " + amount.setScale(2, RoundingMode.HALF_UP) +
                '}';
    }

    public Purchase(long id, LocalDate time, BigDecimal amount) {
        this.id = id;
        this.time = time;
        this.amount = amount;
    }

    @Override
    public int compareTo(Object o) {
        Purchase purchase = (Purchase) o;
        return this.getTime().getYear() - ((Purchase) o).getTime().getYear();
    }
}
