package com.example.fragment.manager.http;


import com.example.fragment.dao.PhotoItemCollectionDao;
import com.example.fragment.dao.PromoteDao;
import com.example.fragment.dao.Update;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.Call;


/**
 * Created by Admin on 11/19/16 AD.
 */
public interface ApiService {

    @POST("tables/adsOut.json")
    Call<PromoteDao> loadPhotoList();

    @FormUrlEncoded
    @POST("tables/feedbacks.php")
    Call<Update> sendFeedback(@Header("Content-Type")String contentType,@Field("feedbacks") String feedback);

}
