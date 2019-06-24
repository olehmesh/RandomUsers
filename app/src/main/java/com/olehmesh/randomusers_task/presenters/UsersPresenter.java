package com.olehmesh.randomusers_task.presenters;

import com.olehmesh.randomusers_task.common.Callback;
import com.olehmesh.randomusers_task.common.UsersContract;
import com.olehmesh.randomusers_task.models.Result;
import com.olehmesh.randomusers_task.network.LoadUserTask;

import java.util.List;

public class UsersPresenter implements UsersContract.Presenter {

  UsersContract.View mView;

  public  UsersPresenter(UsersContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void loadUsers() {

        LoadUserTask.getUsers(new Callback<List<Result>>() {

            @Override
            public void returnResult(List<Result> users) {
                mView.loadDataInList(users);
                mView.hideProgress();

            }

            @Override
            public void returnError(String message) {
                mView.showError(message);
            }
        });
    }

    @Override
    public void onRefreshButtonClick() {
        mView.showProgress();
    }

    @Override
    public void start() {
        mView.init();
    }

}
