package com.music.service;

import com.music.model.Music;

import java.util.List;

public interface MusicService {
    List<Music> findAll();
    void save(Music music);
    void deleteById(Integer id);
    Music findById(Integer id);
}
