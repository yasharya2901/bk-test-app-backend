package com.brahmakumaris.bktestapp.dtos.User;

import com.brahmakumaris.bktestapp.models.Test.Test;
import com.brahmakumaris.bktestapp.models.Test.TestState;
import com.brahmakumaris.bktestapp.models.UserType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class UserCreationDTO {
    private Long userId;
    private String userName;
    private String mobNo;
    private String email;
    private String address;
    private Map<Long, TestState> testStates;  // Map<TestId, TestState>
    private Long batchId;
    private Boolean isActive;
    private List<Long> resultIds; // ResultIDs
    private UserType userType;
}
