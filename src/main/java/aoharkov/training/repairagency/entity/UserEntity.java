package aoharkov.training.repairagency.entity;

import aoharkov.training.repairagency.domain.Role;

import java.util.Objects;

public class UserEntity {
    private final Integer id;
    private final String name;
    private final String surname;
    private final String email;
    private final String password;
    private final Role role;

    private UserEntity(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.email = builder.email;
        this.password = builder.password;
        this.role = builder.role;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserEntity)) {
            return false;
        }
        UserEntity entity = (UserEntity) o;
        return id.equals(entity.id) &&
                Objects.equals(name, entity.name) &&
                Objects.equals(surname, entity.surname) &&
                Objects.equals(email, entity.email) &&
                Objects.equals(password, entity.password) &&
                role == entity.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, password, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }

    public static final class Builder {
        private Integer id;
        private String name;
        private String surname;
        private String email;
        private String password;
        private Role role;

        private Builder() {
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withRole(Role role) {
            this.role = role;
            return this;
        }

        public UserEntity build() {
            return new UserEntity(this);
        }
    }
}
