package com.rovers.service;

import com.rovers.util.RoverUtil;

import javax.ws.rs.core.Response;

public class CheckRoverPositionService implements IRestService<Long> {

    @Override
    public Response execute(Long position) {
        // Dont do anything with position. I just need to fetch a value
        int[][] coordinates = RoverUtil.checkRoverPosition();
        return null;
    }
}
