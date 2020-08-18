package com.cjq.service;

import com.cjq.bean.ConsultContent;
import rx.Observable;

import java.util.List;
import java.util.concurrent.Future;

public interface UserService {

    List<ConsultContent> queryContents();

    Future<String> queryContentsAsyn();

    List<ConsultContent> queryContent();

    String queryMonitor();

    public Observable<String> mergeResult();
}
