package com.example.lamnn.todo_mvp.data.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Task implements Serializable {
  private int mUserId;
  private int mId;
  private String mTitle;
  private boolean mCompleted;

  public Task(JSONObject jsonObject) throws JSONException {
    mUserId = jsonObject.getInt(JSONKey.USER_ID);
    mId = jsonObject.getInt(JSONKey.ID);
    mTitle = jsonObject.getString(JSONKey.TITLE);
    mCompleted = jsonObject.getBoolean(JSONKey.COMPLETED);
  }

  public int getmUserId() {
    return mUserId;
  }

  public void setmUserId(int mUserId) {
    this.mUserId = mUserId;
  }

  public int getmId() {
    return mId;
  }

  public void setmId(int mId) {
    this.mId = mId;
  }

  public String getmTitle() {
    return mTitle;
  }

  public void setmTitle(String mTitle) {
    this.mTitle = mTitle;
  }

  public boolean ismCompleted() {
    return mCompleted;
  }

  public void setmCompleted(boolean mCompleted) {
    this.mCompleted = mCompleted;
  }

  public static class JSONKey {
    public static final String USER_ID = "userId";
    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String COMPLETED = "completed";
  }
}
