package ch.zli.m223.model;


public interface Booking {
        public Long getId();
        public Long getUserId();
        public String getBookingDate();
        public Long getDuration();
        public Long getBookingStatus();

        public void setUserId(Long userId);
        public void setBookingDate(String bookingDate);
        public void setDuration(Long duration);
        public void setBookingStatus(Long bookingStatus);

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
