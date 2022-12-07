package com.codegym.repository;

import com.codegym.entity.Music;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MusicRepoImpl implements IMusicRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Music> findAllMusic() {
        List<Music> musicList = entityManager
                .createQuery("select c from music c")
                .getResultList();
        return musicList;
    }

    @Modifying
    @Override
    public void create(Music music) {
        if (music.getNameSong() == null)
            entityManager.persist(music);
        else {
            entityManager.merge(music);
        }
    }

    @Modifying
    @Override
    public void update(Music music) {
    }

    @Override
    public Music findMusicByName(String nameSong) {
        return entityManager.find(Music.class, nameSong);
    }

    @Modifying
    @Override
    public void delete(String name) {
        Music music = findMusicByName(name);
        entityManager.remove(music);
    }
}
