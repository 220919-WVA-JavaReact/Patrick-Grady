package com.revature.models;

import java.util.Date;

    public class Report {
        private int id;
        private int userid;
        private float amount;
        private String description;
        private String status;
        private Date date;

        // -------------------
        // Constructors
        // -------------------

        public Report(int userid, float amount, String description) {
            this.userid = userid;
            this.amount = amount;
            this.description = description;
        }

        public Report(int userid, float amount, String description, String status, Date date) {
            this.userid = userid;
            this.amount = amount;
            this.description = description;
            this.status = status;
            this.date = date;
        }

        public Report(int id, int userid, float amount, String description, String status, Date date) {
            this.id = id;
            this.userid = userid;
            this.amount = amount;
            this.description = description;
            this.status = status;
            this.date = date;
        }

        // -------------------
        // Getters
        // -------------------

        public int getId() { return id; }
        public int getUserId() { return userid; }
        public float getAmount() {
            return amount;
        }
        public String getDescription() {
            return description;
        }
        public String getStatus() {
            return status;
        }
        public Date getDate() {
            return date;
        }

    }
