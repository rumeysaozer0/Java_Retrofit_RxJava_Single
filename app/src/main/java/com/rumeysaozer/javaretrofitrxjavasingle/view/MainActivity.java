package com.rumeysaozer.javaretrofitrxjavasingle.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.rumeysaozer.javaretrofitrxjavasingle.adapter.BloodAdapter;
import com.rumeysaozer.javaretrofitrxjavasingle.databinding.ActivityMainBinding;
import com.rumeysaozer.javaretrofitrxjavasingle.model.BloodItem;
import com.rumeysaozer.javaretrofitrxjavasingle.service.BloodAPIService;

import java.util.ArrayList;
import java.util.List;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    CompositeDisposable disposable;
    BloodAPIService bloodAPIService = new BloodAPIService();
    BloodAdapter adapter;
    ArrayList<BloodItem> bloodList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        loadData();
    }
    private void loadData(){
        disposable = new CompositeDisposable();

        disposable.add(
              bloodAPIService.getData()
                      .subscribeOn(Schedulers.io())
                      .observeOn(AndroidSchedulers.mainThread())
                      .subscribeWith(new DisposableSingleObserver<List<BloodItem>>() {
                          @Override
                          public void onSuccess(List<BloodItem> bloodItems) {
                            binding.recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                            bloodList = new ArrayList<>(bloodItems);
                            adapter = new BloodAdapter(bloodList);
                            binding.recyclerView.setAdapter(adapter);
                          }

                          @Override
                          public void onError(Throwable e) {
                            e.printStackTrace();
                          }
                      })
        );
    }
}