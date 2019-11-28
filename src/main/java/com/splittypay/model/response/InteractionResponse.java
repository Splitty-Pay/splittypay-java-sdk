package com.splittypay.model.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InteractionResponse {

    private String name;
    private String surname;
    private int amount;
    private String invitation;
    private int preAuthAmount;
    private int fee;
    private String type;
    private String pan;
    private String email;
    private int status;
    private String creation;
    private String resultCode;
    private String resultMessage;
    private String userId;

}
