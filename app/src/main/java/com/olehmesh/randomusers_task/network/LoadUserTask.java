package com.olehmesh.randomusers_task.network;

import com.olehmesh.randomusers_task.common.Callback;
import com.olehmesh.randomusers_task.models.ApiResponse;
import com.olehmesh.randomusers_task.models.Result;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import java.util.List;

public class LoadUserTask {

        public static void getUsers(final Callback<List<Result>> callback) {

           RetrofitInstance.getClient().create(IRandUsers.class)
                   .fetchUsers(15)
                   .subscribeOn(Schedulers.io())
                   .observeOn(AndroidSchedulers.mainThread())
                   .subscribe(new DisposableSingleObserver<ApiResponse>() {

                       @Override
                       public void onSuccess(ApiResponse apiResponse) {
                           List<Result> mlist = apiResponse.getResults();
                           callback.returnResult(mlist);
                       }

                       @Override
                       public void onError(Throwable e) {
                           callback.returnError(e.getMessage());

                       }

                   });

        }
    }


