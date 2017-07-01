package com.dp.digip.components.interfaces;

import com.dp.digip.models.DTO.ServerLocation;


public interface ServerLocationBo {
	
	ServerLocation getLocation(String ipAddress);

}
