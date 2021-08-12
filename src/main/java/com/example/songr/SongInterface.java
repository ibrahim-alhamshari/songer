package com.example.songr;

import org.springframework.data.repository.CrudRepository;

public interface SongInterface extends CrudRepository<Song , Integer> {

}
