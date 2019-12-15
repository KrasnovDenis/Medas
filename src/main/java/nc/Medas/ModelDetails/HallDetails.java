package nc.Medas.ModelDetails;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HallDetails {

    private String title;
    private Date dateTime;
    private int capacity;

    public void setBusySeats(List<Integer> busySeats) {
        this.busySeats = new ArrayList<>(busySeats);
    }

    private List<Integer> busySeats;

    public String getTitle() {
        return title;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Integer> getBusySeats() {
        return new ArrayList<>(busySeats);
    }

    private HallDetails(HallDetailsBuilder builer) {
        this.title = builer.title;
        this.busySeats = new ArrayList<>(builer.busySeats);
        this.capacity = builer.capacity;
        this.dateTime = builer.dateTime;
    }

    public static class HallDetailsBuilder {

        private String title;
        private Date dateTime;
        private int capacity;
        private List<Integer> busySeats;

        public HallDetailsBuilder() {

        }
        public HallDetailsBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public HallDetailsBuilder setDateTime(Date dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public HallDetailsBuilder setCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public HallDetailsBuilder setBusySeats(List<Integer> busySeats) {
            this.busySeats = new ArrayList<>(busySeats);
            return this;
        }

        public HallDetails build() {
            return new HallDetails(this);
        }
    }

}
