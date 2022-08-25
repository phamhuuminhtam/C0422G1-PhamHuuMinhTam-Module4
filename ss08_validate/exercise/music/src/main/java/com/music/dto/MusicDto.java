package com.music.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class MusicDto {
    private Integer id;
    @NotBlank(message = "Please Input!")
    @Pattern(regexp = "^[a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêđâ0-9A-ZĐỲỌÁẦẢẤỜỄÀẠẰỆẾÝỘẬỐŨỨĨÕÚỮỊỖÌỀỂẨỚẶÒÙỒỢÃỤỦÍỸẮẪỰỈỎỪỶỞÓÉỬỴẲẸÈẼỔẴẺỠƠÔƯĂÊÂ ]+$",message = "Wrong format")
    @Size( max = 800,message = "max size 800 words")
    private String name;

    @NotBlank(message = "Please Input!")
    @Pattern(regexp = "^[a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ0-9A-ZĐỲỌÁẦẢẤỜỄÀẠẰỆẾÝỘẬỐŨỨĨÕÚỮỊỖÌỀỂẨỚẶÒÙỒỢÃỤỦÍỸẮẪỰỈỎỪỶỞÓÉỬỴẲẸÈẼỔẴẺỠƠÔƯĂÊÂ ]+$",message = "Wrong format")
    @Size(max = 300,message = "max size 800 words")
    private String singer;

    @NotBlank(message = "Please Input!")
    @Pattern(regexp = "^[,a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ0-9A-ZĐỲỌÁẦẢẤỜỄÀẠẰỆẾÝỘẬỐŨỨĨÕÚỮỊỖÌỀỂẨỚẶÒÙỒỢÃỤỦÍỸẮẪỰỈỎỪỶỞÓÉỬỴẲẸÈẼỔẴẺỠƠÔƯĂÊÂ ]+$",message = "Wrong format")
    @Size(max = 1000,message = "max size 1000 words" )
    private String category;

    public MusicDto() {
    }

    public MusicDto(Integer id, String name, String singer, String category) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.category = category;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
