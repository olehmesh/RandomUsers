package com.olehmesh.randomusers_task.common;

import com.olehmesh.randomusers_task.models.Result;

import java.util.List;

public class UsersContract {

  public interface View {

        void init();

        void showProgress();

        void hideProgress();

        void showError(String message);

        void loadDataInList(List<Result> users);

    }

  public interface Presenter {

        void onRefreshButtonClick();

        void start();

        void loadUsers();
    }

}
