package pl.rekrutacja.empik.users;

import jakarta.persistence.*;

@Entity
public class UserRequestLog {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "REQUEST_COUNT")
    private int requestCount;

    protected UserRequestLog() {

    }

    public UserRequestLog(String login) {
        this.login = login;
    }

    public void incrementRequestCount() {
        requestCount++;
    }
}
