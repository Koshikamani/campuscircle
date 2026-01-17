package com.cc.campuscircle.dto;

import jakarta.validation.constraints.NotBlank;

public class RegisterRequest {

        @NotBlank
        private String email;

        @NotBlank
        private String rollNumber;
        @NotBlank
        private String password;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getRollNumber() {
            return rollNumber;
        }

        public void setRollNumber(String rollNumber) {
            this.rollNumber = rollNumber;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
}
