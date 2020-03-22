package TurnstileSystem;

import java.util.Date;
import java.util.Objects;

public class TimeCard extends Card{

    Date startDate;
    Date endDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        if(startDate.after(endDate))
            throw new IllegalArgumentException("Дата початку має бути перед датою кінця");
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        if(endDate.before(startDate))
            throw new IllegalArgumentException("Дата кіня повина бути після дати старту ");
        this.endDate = endDate;
    }

    @Override
    public boolean proof() {
        Date today = new Date();
        if(today.after(startDate) && today.before(endDate) && this.isActive())
            return true;
        return  false;
    }
    @Override
    public String toString() {
        return "ID : " +getId() +", Start date : "+startDate+", End date : "+endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeCard timeCard = (TimeCard) o;
        return startDate.equals(timeCard.startDate) &&
                endDate.equals(timeCard.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate);
    }

    public TimeCard(int id, Date startDate, Date endDate){
        super(id);
        if(startDate.after(endDate))
            throw new IllegalArgumentException();
        this.startDate =startDate;
        this.endDate =endDate;
    }
}
