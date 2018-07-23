package com.example.kamal.myapplication.repository;




import com.example.kamal.myapplication.model.MovieModel;
import com.example.kamal.myapplication.network.APIInterface;
import com.example.kamal.myapplication.network.ApiClient;


import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kamal on 8/2/18.
 */

public class MovieRepository {

    private APIInterface apiInterface;


    public MovieRepository() {
    }

    public MutableLiveData<MovieModel> getMovies() {
        final MutableLiveData<MovieModel> refferAndInvitePojoMutableLiveData = new MutableLiveData<>();
        apiInterface = ApiClient.getClientAuthentication().create(APIInterface.class);
        Call<MovieModel> call = apiInterface.getdata();
        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                if(response.body()!=null)
                {
                    refferAndInvitePojoMutableLiveData.setValue(response.body());
                }


            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {

            }
        });

        return refferAndInvitePojoMutableLiveData;
    }
}
