package com.example.lamnn.todo_mvp.data.source;

public interface Callback<T> {
  void getDataSuccess(T tasks);

  void getDataFail(Exception e);
}
