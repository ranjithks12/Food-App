package com.app.util;

import java.io.File;

import javax.servlet.http.HttpServletResponse;

public class Utils {

	private static final String NULL = "null";
	private static final String EMPTY = "";

	// Update this to your local project root path
	private static final String PROJECT_ROOT = "C:/git/Food-App";
	
	// Relative path to images inside your project
	private static final String RELATIVE_IMAGE_PATH = "src/main/webapp/images";
	static String createFolderPath;

	public static boolean validateFeild(String targetValue) {
		return !EMPTY.equals(targetValue) && targetValue != null && !NULL.equals(targetValue);
	}

	public static boolean createFolders(String restaurantName) {
		createFolderPath = PROJECT_ROOT + File.separator + RELATIVE_IMAGE_PATH
                + File.separator + restaurantName + File.separator + "item_images";

        File uploadDir = new File(createFolderPath);
        if (!uploadDir.exists()) {
            return uploadDir.mkdirs();
        }
        return true;
	}
	
	public static File generateRestaurantImageSavePath(String restaurantName) {
		return new File(PROJECT_ROOT + File.separator + RELATIVE_IMAGE_PATH
                + File.separator + restaurantName);
	}
	
	
}
