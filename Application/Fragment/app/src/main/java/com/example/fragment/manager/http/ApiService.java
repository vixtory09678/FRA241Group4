package com.example.fragment.manager.http;


import com.example.fragment.dao.PhotoItemCollectionDao;
import com.example.fragment.dao.Update;

import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.Call;


/**
 * Created by Admin on 11/19/16 AD.
 */
public interface ApiService {

    @POST("list")
    Call<PhotoItemCollectionDao> loadPhotoList();

    @POST("update.json")
    Call<Update> sendFeedback(@Body Update feed);

}
