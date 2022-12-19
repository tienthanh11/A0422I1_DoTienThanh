package com.codegym.validate_thong_tin_bai_hat.model;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicForm {

    @NotBlank(message = "Không được phép để trống")
    @Size(max = 800, message = "Không được vượt quá 800 kí tự")
    @Pattern(regexp = "^\\w*$", message = "Không được chứa các kí tự đặc biệt")
    private String nameSong;

    @NotBlank(message = "Không được phép để trống")
    @Size(max = 300, message = "Không được vượt quá 300 kí tự")
    @Pattern(regexp = "^\\w*$", message = "Không được chứa các kí tự đặc biệt")
    private String singer;

    @NotBlank(message = "Không được phép để trống")
    @Size(max = 1000, message = "Không được vượt quá 1000 kí tự")
    @Pattern(regexp = "^[\\w,]*$", message = "Không được chứa các kí tự đặc biệt ngoài trừ dấu phẩy")
    private String typeOfMusic;

    private MultipartFile path;

    public MusicForm() {
    }

    public MusicForm(@NotBlank(message = "Không được phép để trống")
                     @Size(max = 800, message = "Không được vượt quá 800 kí tự")
                     @Pattern(regexp = "^\\w*$", message = "Không được chứa các kí tự đặc biệt") String nameSong,
                     @NotBlank(message = "Không được phép để trống")
                     @Size(max = 300, message = "Không được vượt quá 300 kí tự")
                     @Pattern(regexp = "^\\w*$", message = "Không được chứa các kí tự đặc biệt") String singer,
                     @NotBlank(message = "Không được phép để trống")
                     @Size(max = 1000, message = "Không được vượt quá 1000 kí tự")
                     @Pattern(regexp = "^[\\w,]*$", message = "Không được chứa các kí tự đặc biệt ngoài trừ dấu phẩy") String typeOfMusic,
                     MultipartFile path) {
        this.nameSong = nameSong;
        this.singer = singer;
        this.typeOfMusic = typeOfMusic;
        this.path = path;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTypeOfMusic() {
        return typeOfMusic;
    }

    public void setTypeOfMusic(String typeOfMusic) {
        this.typeOfMusic = typeOfMusic;
    }

    public MultipartFile getPath() {
        return path;
    }

    public void setPath(MultipartFile path) {
        this.path = path;
    }
}
