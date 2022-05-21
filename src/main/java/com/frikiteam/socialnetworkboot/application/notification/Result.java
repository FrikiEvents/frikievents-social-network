package com.frikiteam.socialnetworkboot.application.notification;

import java.util.function.Consumer;

public abstract class Result<SUCCESS, FAILURE> {

  public abstract boolean isSuccess() ;
  public abstract boolean isFailure() ;
  public abstract SUCCESS getSuccess();
  public abstract FAILURE getFailure();
  public abstract Result<SUCCESS, FAILURE> ifSuccess(Consumer<SUCCESS> consumerSuccess);
  public abstract Result<SUCCESS, FAILURE> ifFailure(Consumer<FAILURE> consumerFailure);

  public  static class Success<SUCCESS, FAILURE> extends Result<SUCCESS, FAILURE> {
    private final SUCCESS success;

    private Success(SUCCESS success) {
      this.success = success;
    }

    @Override
    public boolean isSuccess() {
      return true;
    }

    @Override
    public boolean isFailure() {
      return false;
    }

    @Override
    public SUCCESS getSuccess() {
      return success;
    }

    @Override
    public FAILURE getFailure() {
      throw new IllegalStateException("getFailure called on Success");
    }

    @Override
    public String toString() {
      return "Success [_success=" + success + "]";
    }

    @Override
    public Result<SUCCESS, FAILURE> ifSuccess(Consumer<SUCCESS> consumerSuccess) {
      consumerSuccess.accept(success);
      return this;
    }

    @Override
    public Result<SUCCESS, FAILURE> ifFailure(Consumer<FAILURE> consumerFailure) {
      return this;
    }
  }

  public  static class Failure<SUCCESS, FAILURE> extends Result<SUCCESS, FAILURE> {
    private final FAILURE failure;
    private Failure(FAILURE failure) {
      this.failure = failure;
    }

    @Override
    public boolean isSuccess() {
      return false;
    }

    @Override
    public boolean isFailure() {
      return true;
    }

    @Override
    public SUCCESS getSuccess() {
      throw new IllegalStateException("getSuccess called on Failure");
    }

    @Override
    public FAILURE getFailure() {
      return failure;
    }

    @Override
    public String toString() {
      return "Failure [_failure=" + failure + "]";
    }

    @Override
    public Result<SUCCESS, FAILURE> ifSuccess(Consumer<SUCCESS> consumerSuccess) {
      return this;
    }

    @Override
    public Result<SUCCESS, FAILURE> ifFailure(Consumer<FAILURE> consumerFailure) {
      consumerFailure.accept(failure);
      return this;
    }
  }

  public static <SUCCESS, FAILURE> Result<SUCCESS, FAILURE> failure(FAILURE failure){ return new Failure<>(failure); }
  public static <SUCCESS, FAILURE> Result<SUCCESS, FAILURE> success(SUCCESS success){ return new Success<>(success); }
}