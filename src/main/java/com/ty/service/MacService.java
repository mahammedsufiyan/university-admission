package com.ty.service;

import com.ty.dao.MacDao;
import com.ty.dto.Mac;

public class MacService {
	MacDao macDao = new MacDao();

	public Mac saveMac(Mac mac) {

		return macDao.saveMac(mac);
	}
}