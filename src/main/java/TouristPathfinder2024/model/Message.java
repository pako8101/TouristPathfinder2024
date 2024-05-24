package TouristPathfinder2024.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,name = "date_time")
    private Instant dateTime;
    @Column(name = "text_content",columnDefinition = "TEXT")
    private String content;

    @ManyToOne(optional = false)
    private User author;
    @ManyToOne(optional = false)
    private User recipient;


    public Message() {
    }

    public Long getId() {
        return id;
    }

    public Message setId(Long id) {
        this.id = id;
        return this;
    }

    public Instant getDateTime() {
        return dateTime;
    }

    public Message setDateTime(Instant dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Message setContent(String content) {
        this.content = content;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Message setAuthor(User author) {
        this.author = author;
        return this;
    }

    public User getRecipient() {
        return recipient;
    }

    public Message setRecipient(User recipient) {
        this.recipient = recipient;
        return this;
    }
}
