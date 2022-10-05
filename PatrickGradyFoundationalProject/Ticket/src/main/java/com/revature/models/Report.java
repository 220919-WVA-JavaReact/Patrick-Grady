package com.revature.models;

import java.util.Date;

    public class Report {
        private int id;
        private int userid;
        private float amount;
        private String description;
        private String status;
        private Date date;


        // other fields are either serial or has default values
        public Report(int userid, float amount, String description) {
            this.userid = userid;
            this.amount = amount;
            this.description = description;
        }

        // full constructor for creating new Report from database info
        public Report(int userid, float amount, String description, String status, Date date) {
            this.userid = userid;
            this.amount = amount;
            this.description = description;
            this.status = status;
            this.date = date;
        }

        // empty constructor
        public Report(){}

        // getters and setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public float getAmount() {
            return amount;
        }

        public void setAmount(float amount) {
            this.amount = amount;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

    }
