package ru.miroshka.hibernate.zadanie_1_2;

import jakarta.persistence.*;

    @Entity
    @Table(name = "users_details")
    public class UserDetails {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;
        @Column(name = "email")
        private String email;

        @Column(name = "city")
        private String city;

        @OneToOne(mappedBy = "details")
        private User user;

        public UserDetails() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        @Override
        public String toString() {
            return String.format("UserDetails [id = %d, email = '%s', city = '%s']", id, email, city);
        }

}
