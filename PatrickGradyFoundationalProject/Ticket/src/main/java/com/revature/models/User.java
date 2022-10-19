package com.revature.models;

import com.revature.util.roleType;

import java.util.Objects;

public class User {
        private int id;
        private String fName;
        private String lName;
        private String uName;
        private String password;
        private String role;

        // -------------------
        // Constructors
        // -------------------

        public User(String fName, String lName, String uName, String password) {
            this.fName = fName;
            this.lName = lName;
            this.uName = uName;
            this.password = password;
        }

        public User(int id, String fName, String lName, String uName, String password, String role) {
            this.id = id;
            this.fName = fName;
            this.lName = lName;
            this.uName = uName;
            this.password = password;
            this.role = role;


        }


        // -------------------
        // Getters
        // -------------------

        public int getId() {
            return id;
        }
        public String getfName() {
            return fName;
        }
        public String getlName() {
            return lName;
        }
        public String getuName() {
            return uName;
        }
        public String getPassword() {
            return password;
        }
        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(fName, user.fName) && Objects.equals(lName, user.lName) && Objects.equals(uName, user.uName) && Objects.equals(password, user.password) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fName, lName, uName, password, role);
    }

    @Override
    public String toString() {
        return
                "ID = '" + id + '\'' +
                ", First Name = '" + fName + '\'' +
                ", Last Name = '" + lName + '\'' +
                ", username = '" + uName + '\'' +
                ", role = '" + role + '\'';
    }
}
