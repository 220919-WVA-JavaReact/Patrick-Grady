package com.revature.models;

import java.util.Scanner;
import static java.lang.System.exit;

    public class User {
        private int id;
        private String fName;
        private String lName;
        private String uName;
        private String password;
        private Boolean manager;

        public User() {}

        public User(String fName, String lName, String uName, String password) {
            this.fName = fName;
            this.lName = lName;
            this.uName = uName;
            this.password = password;
        }

        public User(int id, String fName, String lName, String uName, String password, Boolean manager) {
            this.id = id;
            this.fName = fName;
            this.lName = lName;
            this.uName = uName;
            this.password = password;
            this.manager = manager;
        }


        // -------------------
        // getters and setters
        // -------------------

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getfName() {
            return fName;
        }

        public void setfName(String fName) {
            this.fName = fName;
        }

        public String getlName() {
            return lName;
        }

        public void setlName(String lName) {
            this.lName = lName;
        }

        public String getuName() {
            return uName;
        }

        public void setuName(String uName) {
            this.uName = uName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Boolean getManager() {
            return manager;
        }

        public void setManager(Boolean manager) {
            this.manager = manager;
        }
    }
