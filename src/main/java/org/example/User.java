package org.example;

import java.util.Objects;

public class User {
    private long id;
    private String username;
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        if (id != user.id) return false;
        if (!Objects.equals(username, user.username)) return false;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    public User(long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
}
