package com.olehmesh.randomusers_task.views;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.NonNull;

import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.olehmesh.randomusers_task.R;
import com.olehmesh.randomusers_task.adapters.UsersAdapter;
import com.olehmesh.randomusers_task.common.UsersContract;
import com.olehmesh.randomusers_task.presenters.UsersPresenter;
import com.olehmesh.randomusers_task.models.Result;

import java.util.List;

public class MainActivity extends AppCompatActivity implements UsersContract.View {
    List<Result> list;
    UsersAdapter adapter;

    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    public UsersContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mPresenter = new UsersPresenter(this);
        mPresenter.start();

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0 || dy < 0 && fab.isShown())
                    fab.hide();
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    fab.show();
                }
                super.onScrollStateChanged(recyclerView, newState);
            }
        });

    }

    @OnClick(R.id.fab)
    void onClickFab() {
        mPresenter.onRefreshButtonClick();
        mPresenter.loadUsers();

    }

    @Override
    public void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mPresenter.loadUsers();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadDataInList(List<Result> users) {
        adapter = new UsersAdapter(this, list);
        adapter.setData(users);
        recyclerView.setAdapter(adapter);
    }
}