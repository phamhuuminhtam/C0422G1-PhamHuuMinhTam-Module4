package com.music.service.impl;

import com.music.model.Music;
import com.music.repository.MusicRepository;
import com.music.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicRepository musicRepository;
    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }

    @Override
    public void deleteById(Integer id) {
        musicRepository.deleteById(id);
    }

    @Override
    public Music findById(Integer id) {
        return musicRepository.findById(id).orElse(null);
    }
}
