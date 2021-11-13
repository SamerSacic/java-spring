package com.sascode.event;

import java.time.LocalDate;

public class Event {
    private Long id;
    private String title;
    private String content;
    private LocalDate startDate;
    private LocalDate endDate;

    public static class Builder {
        private Long id;
        private String title;
        private String content;
        private LocalDate startDate;
        private LocalDate endDate;


        public Builder(Long id) {
            this.id = id;
        }

        public Builder withTitle(String title) {
            this.title = title;

            return this;
        }

        public Builder withContent(String content) {
            this.content = content;

            return this;
        }

        public Builder withStartDate(LocalDate startDate) {
            this.startDate = startDate;

            return this;
        }

        public Builder withEndDate(LocalDate endDate) {
            this.endDate = endDate;

            return this;
        }

        public Event build() {
            Event event = new Event();
            event.id = id;
            event.title = title;
            event.content = content;
            event.startDate = startDate;
            event.endDate = endDate;

            return event;
        }
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
