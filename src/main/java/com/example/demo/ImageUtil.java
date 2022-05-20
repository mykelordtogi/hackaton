package com.example.demo;

import java.util.Base64;

public class ImageUtil {
    public String getImgData(byte[] photo) {
        return Base64.getMimeEncoder().encodeToString(photo);
    }
}