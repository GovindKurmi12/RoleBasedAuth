package com.gk.auth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Govind Kurmi
 * Date : 11-09-2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    private String username;
    private String password;

}
