package nc.Medas.ModelDetails;

import java.util.Date;

public class TicketDetails {


    private String film;
    private String firstName;
    private String lastName;
    private Date dateScreen;
    private double price;
    private String hallName;
    private int chair;

    public String getFilm() {
        return film;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateScreen() {
        return dateScreen;
    }

    public double getPrice() {
        return price;
    }

    public String getHallName() {
        return hallName;
    }

    public int getChair() {
        return chair;
    }
    TicketDetails(TicketDetailsBuilder builder) {
         film = builder.film;
         firstName = builder.firstName;
         lastName = builder.lastName;
         dateScreen = builder.dateScreen;
         price = builder.price;
         hallName = builder.hallName;
         chair = builder.chair;
    }
    public static class TicketDetailsBuilder {
        private String film;
        private String firstName;
        private String lastName;
        private Date dateScreen;
        private double price;
        private String hallName;
        private int chair;

        public TicketDetailsBuilder() {

        }

        public TicketDetailsBuilder setFilm(String film) {
            this.film = film;
            return this;
        }

        public TicketDetailsBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public TicketDetailsBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public TicketDetailsBuilder setDateScreen(Date dateScreen) {
            this.dateScreen = dateScreen;
            return this;
        }

        public TicketDetailsBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public TicketDetailsBuilder setHallName(String hallName) {
            this.hallName = hallName;
            return this;
        }

        public TicketDetailsBuilder setChair(int chair) {
            this.chair = chair;
            return this;
        }

        public TicketDetails build() {
            return new TicketDetails(this);
        }
    }
}
