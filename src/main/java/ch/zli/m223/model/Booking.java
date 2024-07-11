package ch.zli.m223.model;


public interface Booking {
        public Long getId();
        public Long getUserId();
        public String getBookingDate();
        public Duration getDuration();
        public BookingStatus getBookingStatus();

        public void setUserId(Long userId);
        public void setBookingDate(String bookingDate);
        public void setDuration(Duration duration);
        public void setBookingStatus(BookingStatus bookingStatus);

        enum BookingStatus {
            PENDING,
            CONFIRMED,
            REJECTED
        }

        enum Duration {
                MORNING,
                AFTERNOON,
                FULL_DAY
        }

}
