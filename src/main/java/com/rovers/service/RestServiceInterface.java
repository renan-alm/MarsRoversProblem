package com.rovers.service;

import javax.ws.rs.core.Response;

public interface RestServiceInterface<T> {

    Response execute(T params);

}
