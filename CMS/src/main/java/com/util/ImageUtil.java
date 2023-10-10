package com.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

public class ImageUtil {
	public static String encodeImageToBase64(Blob imageBlob) {
		try (InputStream imageStream = imageBlob.getBinaryStream()) {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = imageStream.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesRead);
			}
			byte[] imageBytes = baos.toByteArray();
			return java.util.Base64.getEncoder().encodeToString(imageBytes);
		} catch (IOException | java.sql.SQLException e) {
			e.printStackTrace();
			return "";
		}
	}
}
