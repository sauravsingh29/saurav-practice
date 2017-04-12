package com.ss.designpatterns;

import java.util.regex.Pattern;

/**
 * Created by Saurav on 12-04-2017.
 */
public class ChainOfResponsibilityDemo {

    public static void main(String[] args) {
        final Request request = new Request("Saurav", "123456789");
        Job<Response, Request> validationJob = new ValidationJob();
        Job<Response, Request> dbJob = new DbJob();
        validationJob.setNextJob(dbJob);

        System.out.println(validationJob.processJob(request));
    }
}

class Request {
    private String accHolderName;
    private String accNumber;

    public Request(String accHolderName, String accNumber) {
        this.accHolderName = accHolderName;
        this.accNumber = accNumber;
    }

    public String getAccHolderName() {
        return accHolderName;
    }

    public String getAccNumber() {
        return accNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Request{");
        sb.append("accHolderName='").append(accHolderName).append('\'');
        sb.append(", accNumber='").append(accNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

class Response {
    private boolean isValid;
    private String type;
    private String messages;

    public Response(boolean isValid, String type, String messages) {
        this.isValid = isValid;
        this.type = type;
        this.messages = messages;
    }

    public boolean isValid() {
        return isValid;
    }

    public String getType() {
        return type;
    }

    public String getMessages() {
        return messages;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Response{");
        sb.append("isValid=").append(isValid);
        sb.append(", type='").append(type).append('\'');
        sb.append(", messages='").append(messages).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

interface Job<O, I> {
    public void setNextJob(final Job nextJob);
    public O processJob(I i);
}

class ValidationJob implements Job<Response, Request> {

    private Job<Response, Request> nextJob;

    @Override
    public void setNextJob(Job nextJob) {
        this.nextJob = nextJob;
    }

    @Override
    public Response processJob(Request request) {
        System.out.println("Performing validation job for request :: "+ request.toString());
        String errMsg = "";
        if (null != request){
            if (!Pattern.matches("[0-9]+", request.getAccNumber()))
                errMsg = "Account number is not numeric. ";
            if (!Pattern.matches("[a-zA-Z]+", request.getAccHolderName()))
                errMsg += " Account holder is having invalid characters. ";

            if (errMsg.length() > 0)
                return new Response(false, "VALIDATION_ERROR", errMsg);

            if (null != this.nextJob)
                return this.nextJob.processJob(request);
        }
        return new Response(true, "SUCCESS", "Validation Job for Request processed  successfully");
    }
}

class DbJob implements Job<Response, Request>{

    private Job<Response, Request> nextJob;

    @Override
    public void setNextJob(Job nextJob) {
        this.nextJob = nextJob;
    }

    @Override
    public Response processJob(Request request) {
        System.out.println("DbJob processing for request" + request.toString());
        if (request.getAccNumber().equals("123456789"))
            return new Response(false, "DB_ERROR", "Unable to store dummy account number");
        if (null != this.nextJob)
            return this.nextJob.processJob(request);

        return new Response(true, "SUCCESS", "DbJob for Request processed  successfully");
    }
}