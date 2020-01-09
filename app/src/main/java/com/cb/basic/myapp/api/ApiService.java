package com.cb.basic.myapp.api;

import com.cb.basic.myapp.bean.response.NameResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * create date on 2019/12/31
 *
 * @author Cbin
 * describe
 */
public interface ApiService {
    String BASE_MOVIE_URL = "api/movie.php";

    /**
     * 测试接口
     *
     * @param action =test
     * @return
     */
    @GET(BASE_MOVIE_URL)
    Observable<NameResponse> Test(@Query("action") String action);
}
