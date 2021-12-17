package com.yjk.common.callback;

public interface ResponseCallback<T> {
    void onResponse(T res);
    void onFailed(String fault);
}
