package com.renhang.springbootlesson2.dto;

/**
 * @author heng.jia
 * @date 2018/6/29 下午2:15
 */
public class FileInfo {

    public FileInfo(String path) {
        this.path = path;
    }

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
