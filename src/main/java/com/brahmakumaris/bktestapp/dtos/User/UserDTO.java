package com.brahmakumaris.bktestapp.dtos.User;

import com.brahmakumaris.bktestapp.models.Test.Test;
import com.brahmakumaris.bktestapp.models.Test.TestState;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class UserDTO {
    private Long userId;
    private String userName;
    private String mobNo;
    private String email;
    private String address;
    private Map<Test, TestState> testStates;
    private Long batchId;
    private String batchName;
}
