package com.brahmakumaris.bktestapp.models;

public enum UserType {
    ROLE_ADMIN,
    ROLE_CLIENT
}

// Added "ROLE_" prefix to follow the convention of Spring Security.
// Otherwise, it will not work properly.