package com.cb.basic.myapp.api;

import com.cb.basic.myapp.bean.NameBean;

import okhttp3.MultipartBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
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
    String BASE_BXM_URL = "http://2b.tandehao.com/adMaterialApi/getAdMaterial";

    /**
     * 测试接口
     *
     * @param action =test
     * @return
     */
    @GET(BASE_MOVIE_URL)
    Observable<NameBean> Test(@Query("action") String action);
}
