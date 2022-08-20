package com.codegym.repository.impl;

import com.codegym.model.Music;
import com.codegym.repository.MusicRepository;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MusicRepositoryImpl implements MusicRepository {
    @Override
    public List<Music> findAll() {
        TypedQuery typedQuery = BaseRepository.entityManager.createQuery("select m from Music m", Music.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(music);
        entityTransaction.commit();
    }

    @Override
    public Music findById(int id) {
        Music music =BaseRepository.entityManager.find(Music.class,id);

        return music;
    }

    @Override
    public void update( Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(music);
        entityTransaction.commit();
    }

    @Override
    public void remove(int id) {
        Music music = BaseRepository.entityManager.find(Music.class,id);
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(music);
        entityTransaction.commit();
    }
}
