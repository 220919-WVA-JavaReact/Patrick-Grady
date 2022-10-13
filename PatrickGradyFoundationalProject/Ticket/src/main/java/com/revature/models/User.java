package com.revature.models;

import com.revature.util.roleType;

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
}
