package id.imam.cobakkp.apiclient;

import java.util.List;

import id.imam.cobakkp.model.ModelWisata;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("Wisatas")
    Call<List<ModelWisata>>getWisatas();
}
