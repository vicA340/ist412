package com.example.atzfinance.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="messages")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="sentBy")
    private String sentBy;

    @Column(name="sentTo")
    private String sentTo;

    @Column(name="content")
    private String content;
    
    public void setSentBy(String sentBy) {
        this.sentBy = sentBy;
    }

    public String getSentBy() {
        return this.sentBy;
    }

    public void setSentTo(String sentTo) {
        this.sentTo = sentTo;
    }

    public String getSentTo() {
        return this.sentTo;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }
}
