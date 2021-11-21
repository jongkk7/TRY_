package com.yjk.yjk.callback;

public interface ResponseCallback<T> {
    void onResponse(T res);
    void onFailed(String fault);
}
