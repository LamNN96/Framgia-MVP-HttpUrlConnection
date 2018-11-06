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

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int userId) {
        mUserId = userId;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public boolean isCompleted() {
        return mCompleted;
    }

    public void setCompleted(boolean completed) {
        mCompleted = completed;
    }

    public static class JSONKey {
        public static final String USER_ID = "userId";
        public static final String ID = "id";
        public static final String TITLE = "title";
        public static final String COMPLETED = "completed";
    }
}
