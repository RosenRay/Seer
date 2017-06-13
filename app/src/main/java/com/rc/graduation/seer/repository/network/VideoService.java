package com.rc.graduation.seer.repository.network;

import com.rc.graduation.seer.mvp.model.entity.videos.VideoData;

import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 视频接口
 *
 * @version 1.0
 * @author  rosen
 * Created by Administrator on 2016/11/24.
 */

public interface VideoService {

    @GET("nc/video/list/{videoType}/n/{startPage}-10.html")
    Observable<Map<String,List<VideoData>>> getVideoList(
            @Header("Cache-Control") String cacheControl,
            @Path("videoType") String videoType,
            @Path("startPage") int startPage);

}
